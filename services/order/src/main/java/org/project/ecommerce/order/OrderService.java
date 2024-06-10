package org.project.ecommerce.order;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.project.ecommerce.customer.CustomerClient;
import org.project.ecommerce.exception.BusinessException;
import org.project.ecommerce.kafka.OrderConfirmation;
import org.project.ecommerce.kafka.OrderProducer;
import org.project.ecommerce.orderLine.OrderLineRequest;
import org.project.ecommerce.orderLine.OrderLineService;
import org.project.ecommerce.payment.PaymentClient;
import org.project.ecommerce.payment.PaymentRequest;
import org.project.ecommerce.product.ProductClient;
import org.project.ecommerce.product.PurchaseRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest orderRequest) {
        // check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot Create Order:: No Customer Exists With Provided ID"));
        // purchase the products --> product-ms (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(orderRequest.products());
        // persist order
        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));
        // persist order lines
        for (PurchaseRequest purchaseRequest: orderRequest.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // todo start payment process
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        // send the order confirmation -- notification-ms (kafka)
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this.orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(this.orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("No Order Found with ID: " + orderId));
    }
}
