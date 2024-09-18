package com.app.ecommerce.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.ProductImageService;
import com.app.application.interfaces.ProductService;
import com.app.ecommerce.api.helper.ProductHelper;
import com.app.ecommerce.api.request.ProductRequest;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/products")
@Tag(name = "Products", description = "Product management API")
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    ProductController(ProductService productService,ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductsDTO>>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam("storeId") String storeId) {
        return ResponseEntity.ok(productService.findAllByStoreIdWithPageable(storeId, page, size));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ProductsDTO>> getById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> post(
            @ModelAttribute ProductRequest productRequest) {
        ProductsDTO productsDTO = ProductHelper.convertoTProductsDTO(productRequest);
        productService.createProduct(productRequest.getProductImages(), productsDTO);
        return ResponseEntity.ok("Product has been create");
    }

    // @PutMapping(value="{id}",consumes = "multipart/form-data")
    // public ResponseEntity<String> put(@RequestParam String id, @ModelAttribute ProductRequest productRequest) {
    //     ProductsDTO productsDTO = ProductHelper.convertoTProductsDTO(productRequest);
    //     productService.updateProduct(id, productRequest.getProductImages(), productsDTO);
    //     return ResponseEntity.ok("Product has been updated");
    // }

    // @DeleteMapping
    // public ResponseEntity<String> delete() {
    //     return ResponseEntity.ok("Product API already");
    // }

    // @DeleteMapping("/product-image/{id}")
    // public ResponseEntity<String> deleteProductImageById(@PathVariable(value = "id") String id){
    //     productImageService.delete(id);
    //     return ResponseEntity.ok("Product image has been delete");
    // }

}
