package com.app.ecommerce.api.controllers.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductService;


@RestController
@RequestMapping("${api.prefix.client}/products")
public class ProductClientController {

    private final ProductService productService;

    ProductClientController(ProductService service) {
        this.productService = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductsDTO>>> getProduct() {
        return ResponseEntity.ok(productService.getProduct());
    }

}
