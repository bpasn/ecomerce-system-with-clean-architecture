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

import com.app.application.dto.CategoriesDTO;
import com.app.application.service.CategoriesServiceImpl;

@RestController
@RequestMapping("${api.prefix.route}/categories")
public class CategoriesController {
    private final CategoriesServiceImpl categoriesService;

    CategoriesController(CategoriesServiceImpl categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<String> get(@RequestParam String email) {
        return ResponseEntity.ok("Categories API already");
    }
    @PostMapping
    public ResponseEntity<String> post(@RequestBody CategoriesDTO categories) {
        categoriesService.create(categories);
        return ResponseEntity.ok("Categories has created");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("Categories API already");
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Categories API already");
    }
}
