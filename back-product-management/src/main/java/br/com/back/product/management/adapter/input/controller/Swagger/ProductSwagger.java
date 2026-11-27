package br.com.back.product.management.adapter.input.controller.Swagger;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.adapter.input.controller.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Products", description = "Operações de gerenciamento de produtos")
@RequestMapping("/products")
public interface ProductSwagger {

    @Operation(summary = "Cria um produto", description = "Cadastra um novo produto pelo SKU")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Dados do produto",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductRequest.class),
                    examples = @ExampleObject(name = "Produto válido", value = ProductExamples.CREATE_REQUEST)
            )
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado",
                    content = @Content(examples = @ExampleObject(value = ProductExamples.CREATE_RESPONSE))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content(examples = @ExampleObject(value = ProductExamples.VALIDATION_ERROR))),
            @ApiResponse(responseCode = "409", description = "SKU duplicado",
                    content = @Content(examples = @ExampleObject(value = ProductExamples.DUPLICATE_SKU)))
    })
    @PostMapping("/create")
    ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request);
}
