package br.com.back.product.management.adapter.input.controller.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "{0010}")
        @Size( max = 50, message = "{0016}")
        String sku,

        @NotBlank(message = "{0011}")
        @Size( max = 150, message = "{0017}")
        String nome,

        String description,

        @Size(max = 100, message = "{0021}")
        String category,

        @Size(max = 100, message = "{0022}")
        String brand,

        @Size(max = 50, message = "{0023}")
        String barCode,

        @NotNull(message = "{0012}")
        @Positive
        @Digits(integer = 10, fraction = 2, message = "{0018}")
        BigDecimal costPrice,

        @NotNull(message = "{0013}")
        @Positive
        @Digits(integer = 10, fraction = 2, message = "{0018}")
        BigDecimal sellPrice,

        @NotNull(message = "{0014}")
        @Positive(message = "{0015}")
        @Digits(integer = 7, fraction = 3, message = "{0018}")
        BigDecimal weight
) {
}
