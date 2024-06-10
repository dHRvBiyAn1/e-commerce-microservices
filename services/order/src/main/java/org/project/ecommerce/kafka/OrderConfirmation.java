package org.project.ecommerce.kafka;

import org.project.ecommerce.customer.CustomerResponse;
import org.project.ecommerce.order.PaymentMethod;
import org.project.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
