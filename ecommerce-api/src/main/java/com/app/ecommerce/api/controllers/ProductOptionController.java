package com.app.ecommerce.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
@RestController
@RequestMapping(value = "${api.prefix.route}/product-option")
@Tag(name = "Product Option", description = "Product option management API")

public class ProductOptionController {

    private final ProductOptionService productOptionService;

    public ProductOptionController(ProductOptionService productOptionService) {
        this.productOptionService = productOptionService;
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductOptionDTO>>> get(@RequestParam(value = "storeId",required = true) String storeId) {
        return ResponseEntity.ok(productOptionService.getAllByStoreId(storeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductOptionDTO>> getById(@PathVariable String id){
        return ResponseEntity.ok(productOptionService.getById(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody ProductOptionDTO productOptionDTO) {
        productOptionService.create(productOptionDTO);
        return ResponseEntity.ok("Product option has been created!!");
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
