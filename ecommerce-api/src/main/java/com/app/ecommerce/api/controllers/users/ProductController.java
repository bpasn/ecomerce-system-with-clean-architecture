package com.app.ecommerce.api.controllers.users;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoryWithProductDTO;
import com.app.application.interfaces.CategoryService;
import com.app.application.interfaces.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${api.prefix.route}/product")
@Tag(name = "ProductController",description = "Product manage for client")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    ProductController(ProductService productService,CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryWithProductDTO>>> getAll(){
        return ResponseEntity.ok(categoryService.getAllCategoryWIthProduct());
    }
}
