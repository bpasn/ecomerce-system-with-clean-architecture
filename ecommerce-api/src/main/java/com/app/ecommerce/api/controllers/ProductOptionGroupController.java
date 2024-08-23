package com.app.ecommerce.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ProductOptionGroupDTO;
import com.app.application.service.ProductOptionGroupServiceImpl;

@RestController
@RequestMapping("${api.prefix.route}/product-option-groups")
public class ProductOptionGroupController {
    private final ProductOptionGroupServiceImpl productOptionGroupService;

    ProductOptionGroupController(ProductOptionGroupServiceImpl productOptionGroupService) {
        this.productOptionGroupService = productOptionGroupService;
    }

    @GetMapping
    public ResponseEntity<String> get(@RequestParam String email) {
        return ResponseEntity.ok("ProductOptionGroup API already");
    }
    @PostMapping
    public ResponseEntity<String> post(@RequestBody ProductOptionGroupDTO productOptionGroup) {
        productOptionGroupService.create(productOptionGroup);
        return ResponseEntity.ok("ProductOptionGroup API already");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("ProductOptionGroup API already");
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("ProductOptionGroup API already");
    }
}
