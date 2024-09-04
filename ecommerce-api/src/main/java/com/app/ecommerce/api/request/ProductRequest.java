package com.app.ecommerce.api.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    ProductFormData products;
    List<MultipartFile> productImages;
    public ProductFormData getProducts() {
        return products;
    }
    public void setProducts(ProductFormData products) {
        this.products = products;
    }
    public List<MultipartFile> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }
    @Override
    public String toString() {
        return "ProductRequest [products=" + products + ", productImages=" + productImages + "]";
    }
    
}
