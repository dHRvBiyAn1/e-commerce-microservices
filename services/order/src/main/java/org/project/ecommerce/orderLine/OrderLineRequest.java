package org.project.ecommerce.orderLine;

public record OrderLineRequest(
                Integer id,
                Integer orderId,
                Integer productId,
                double quantity
) {
}
