package com.app.ecommerce.api.controllers.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.interfaces.CategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/admin/categories")
@Tag(name = "Categories", description = "Categories management API")
public class AdminCategoriesController {
    private final CategoryService categoriesService;

    AdminCategoriesController(CategoryService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoriesDTO>>> get(@RequestParam(value = "storeId",required = true) String storeId) {
        return ResponseEntity.ok(categoriesService.getAllByStoreId(storeId));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CategoriesDTO>> getById(@PathVariable String id){
        return ResponseEntity.ok(categoriesService.getById(id));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<CategoriesDTO>> post(@RequestBody CategoriesDTO categories) {
        return ResponseEntity.ok(categoriesService.create(categories));
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
