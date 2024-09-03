package com.app.ecommerce.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;
import com.app.ecommerce.api.request.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/products")
@Tag(name = "Products", description = "Product management API")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductsDTO>>> get(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getAllWithPage(page, size));
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> post(
            @ModelAttribute ProductRequest productRequest)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductsDTO productsDTO = objectMapper.readValue(productRequest.getProducts(), ProductsDTO.class);
        productsDTO.setProductImages(productRequest.getProductImages());
        productService.create(productsDTO);
        return ResponseEntity.ok("Product has create");
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestParam Long id, @RequestBody ProductsDTO products) {
        return ResponseEntity.ok("Product API already");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Product API already");
    }

}
