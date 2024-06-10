package org.project.ecommerce.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "Firstname is Required")
        String firstName,
        @NotNull(message = "Lastname is Required")
        String lastName,
        @NotNull(message = "Email is Required")
        @Email(message = "The Customer Email is Not Valid")
        String email
) {
}
