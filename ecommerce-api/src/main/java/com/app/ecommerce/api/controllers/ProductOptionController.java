package com.app.ecommerce.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import java.util.List;
@RestController
@RequestMapping(value = "${api.prefix.route}/product-option")
public class ProductOptionController {

    private final ProductOptionService productOptionService;

    public ProductOptionController(ProductOptionService productOptionService) {
        this.productOptionService = productOptionService;
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductOptionDTO>>> get() {
        return ResponseEntity.ok(productOptionService.getAll());
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody ProductOptionDTO productOptionDTO) {
        productOptionService.create(productOptionDTO);
        return ResponseEntity.ok("Product option has created!!");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("ProductOption API already");
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("ProductOption API already");
    }
}
