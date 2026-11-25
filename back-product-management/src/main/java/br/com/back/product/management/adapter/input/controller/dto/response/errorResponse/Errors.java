package br.com.back.product.management.adapter.input.controller.dto.response.errorResponse;

public record Errors(
        String field,
        String message
) {
}
