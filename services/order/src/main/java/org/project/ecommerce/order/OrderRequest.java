package org.project.ecommerce.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.project.ecommerce.product.PurchaseRequest;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderRequest(
        Integer id,
        String reference,

        @Positive(message = "Order Amount Should be Positive")
        BigDecimal amount,

        @NotNull(message = "Payment Method Should be Precised")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer Should be Present")
        @NotEmpty(message = "Customer Should be Present")
        @NotBlank(message = "Customer Should be Present")
        String customerId,

        @NotEmpty(message = "You Should at Least Purchase one Product")
        List<PurchaseRequest> products
) {
}
