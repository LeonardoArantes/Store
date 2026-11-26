package br.com.back.product.management.adapter.input.controller.dto.response.errorResponse;

import java.util.List;

public record ErrorResponse(
        List<Errors> errors
) {
}
