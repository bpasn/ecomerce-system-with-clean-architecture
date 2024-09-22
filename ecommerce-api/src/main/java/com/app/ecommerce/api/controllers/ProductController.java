package com.app.ecommerce.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.BaseResponse;
import com.app.application.dto.ProductsDTO;
import com.app.application.dto.StockDTO;
import com.app.application.interfaces.ProductImageService;
import com.app.application.interfaces.ProductService;
import com.app.application.interfaces.StockService;
import com.app.domain.pageable.PageResult;
import com.app.ecommerce.api.helper.ProductHelper;
import com.app.ecommerce.api.request.ProductRequest;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("${api.prefix.route}/products")
@Tag(name = "Products", description = "Product management API")
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;
    private final StockService stockService;

    public ProductController(ProductService productService, ProductImageService productImageService,
            StockService stockService) {
        this.productService = productService;
        this.productImageService = productImageService;
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResult<ProductsDTO>>> get(
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

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok("Product has been delete");
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<String> put(
            @PathVariable String id,
            @ModelAttribute ProductRequest productRequest) {
        ProductsDTO productsDTO = ProductHelper.convertoTProductsDTO(productRequest);
        System.out.println("PRODUCTIMAGE : "+productRequest.getProductImages());
        productService.updateProduct(id, productRequest.getProductImages(), productsDTO);
        return ResponseEntity.ok("Product has been updated");
    }

    @DeleteMapping("product-image/{id}")
    public ResponseEntity<String> deleteProductImageById(@PathVariable(value = "id") String id) {
        productImageService.delete(id);
        return ResponseEntity.ok("Product image has been delete");
    }

    @PutMapping("/stock")
    public ResponseEntity<BaseResponse> updateStock(@RequestBody StockDTO sdto) {
        stockService.updateStock(sdto);
        return ResponseEntity.ok(new BaseResponse());
    }

}
