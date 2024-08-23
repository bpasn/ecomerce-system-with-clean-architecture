package com.app.ecommerce.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ProductsDTO;
import com.app.application.service.ProductServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/products")
@Tag(name = "Products", description = "Product management API")
public class ProductController {

    private final ProductServiceImpl productService;

    ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductsDTO>> get(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody ProductsDTO products) {
        return ResponseEntity.ok(products.toString());
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
