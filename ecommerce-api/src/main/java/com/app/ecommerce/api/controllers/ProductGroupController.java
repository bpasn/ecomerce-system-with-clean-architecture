package com.app.ecommerce.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.app.application.ApiResponse;
import com.app.application.dto.ProductGroupDTO;
import com.app.application.interfaces.ProductGroupService;

@RestController
@RequestMapping("${api.prefix.route}/product-groups")
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductGroupDTO>>> get() {
        return ResponseEntity.ok(productGroupService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody ProductGroupDTO productGroup) {
        productGroupService.create(productGroup);
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
