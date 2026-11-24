package br.com.back.product.management.adapter.input.controller.dto.request;

import java.math.BigDecimal;

public record ProductRequest(
        String sku,
        String nome,
        String description,
        String category,
        String brand,
        String barCode,
        BigDecimal costPrice,
        BigDecimal sellPrice,
        String measurementUnit
) {
}
