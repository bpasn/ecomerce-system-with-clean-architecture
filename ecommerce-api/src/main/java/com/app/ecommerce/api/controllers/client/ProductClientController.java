package com.app.ecommerce.api.controllers.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoryWithProductDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.interfaces.ProductService;


@RestController
@RequestMapping("${api.prefix.client}/products")
public class ProductClientController {

    private final ProductService productService;
    private final CategoryService categoryService;

    ProductClientController(ProductService service,CategoryService categoryService) {
        this.productService = service;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductsDTO>>> getProduct() {
        return ResponseEntity.ok(productService.getProduct());
    }

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<CategoryWithProductDTO>>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategoryWIthProduct());
    }

}
