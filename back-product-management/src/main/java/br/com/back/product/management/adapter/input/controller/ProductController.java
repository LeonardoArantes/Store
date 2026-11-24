package br.com.back.product.management.adapter.input.controller;

import br.com.back.product.management.adapter.input.controller.dto.request.ProductRequest;
import br.com.back.product.management.adapter.input.controller.dto.response.ProductResponse;
import br.com.back.product.management.adapter.input.controller.mapper.ProductMapper;
import br.com.back.product.management.port.input.ProductManagementInputPort;
import br.com.back.product.management.port.output.LoggerOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductManagementInputPort productManagementInputPort;
    private final LoggerOutputPort logger;

    public ProductController(ProductMapper productMapper, ProductManagementInputPort productManagementInputPort, LoggerOutputPort logger) {
        this.productMapper = productMapper;
        this.productManagementInputPort = productManagementInputPort;
        this.logger = logger;
    }


    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request){
        logger.info("Received request to create product");
        productManagementInputPort.createProduct(productMapper.toDomain(request));
        ProductResponse response = new ProductResponse("0001", "Product Created");
        return ResponseEntity.ok(response);
    }
}
