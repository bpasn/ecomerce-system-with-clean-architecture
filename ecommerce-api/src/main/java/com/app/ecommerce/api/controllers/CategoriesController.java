package com.app.ecommerce.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/categories")
@Tag(name = "Categories", description = "Categories management API")
public class CategoriesController {
    private final CategoryService categoriesService;

    CategoriesController(CategoryService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoriesDTO>>> get() {
        return ResponseEntity.ok(categoriesService.getAll());
    }
   
    @PostMapping
    public ResponseEntity<ApiResponse<CategoriesDTO>> post(@RequestBody CategoriesDTO categories) {
        return ResponseEntity.ok(categoriesService.create(categories)        );
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
