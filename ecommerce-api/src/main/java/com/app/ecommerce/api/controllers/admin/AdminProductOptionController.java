package com.app.ecommerce.api.controllers.admin;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
@RestController
@RequestMapping(value = "${api.prefix.route}/admin/product-option")
@Tag(name = "Product Option", description = "Product option management API")

public class AdminProductOptionController {

    private final ProductOptionService productOptionService;

    public AdminProductOptionController(ProductOptionService productOptionService) {
        this.productOptionService = productOptionService;
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductOptionDTO>>> get(@RequestParam(value = "storeId",required = true) String storeId) {
        return ResponseEntity.ok(productOptionService.getAllByStoreId(storeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductOptionDTO>> getById(@PathVariable String id){
        return ResponseEntity.ok(productOptionService.getById(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody ProductOptionDTO productOptionDTO) {
        productOptionService.create(productOptionDTO);
        return ResponseEntity.ok("Product option has been created!!");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("ProductOption API already");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        productOptionService.delete(id);
        return ResponseEntity.ok("ProductOption has been delete");
    }
}
