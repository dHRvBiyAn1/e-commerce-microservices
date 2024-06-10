package org.project.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product Name is Required")
        String name,
        @NotNull(message = "Product Description is Required")
        String description,
        @Positive(message = "Available Quantity Should Be Positive")
        double availableQuantity,
        @Positive(message = "Price Should Be Positive")
        BigDecimal price,
        @NotNull(message = "Product Category is Required")
        Integer categoryId
) {
}