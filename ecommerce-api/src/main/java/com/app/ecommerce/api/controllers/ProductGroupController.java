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

import com.app.application.dto.ProductGroupDTO;
import com.app.application.mapper.ProductGroupMapper;
import com.app.application.service.ProductGroupServiceImpl;

@RestController
@RequestMapping("${api.prefix.route}/product-groups")
public class ProductGroupController {
    private final ProductGroupServiceImpl productGroupService;

    ProductGroupController(ProductGroupServiceImpl productGroupService) {
        this.productGroupService = productGroupService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductGroupDTO>> get(@RequestParam int page,@RequestParam int size) {
        return ResponseEntity.ok(productGroupService.getAll(page, size));
    }
    @PostMapping
    public ResponseEntity<String> post(@RequestBody ProductGroupDTO productOptionGroup) {
        productGroupService.create(productOptionGroup);
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
