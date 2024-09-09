package com.app.ecommerce.api.request;

import java.util.List;


public class ProductRequest {
    ProductFormData products;
    List<Object> productImages;
    public ProductFormData getProducts() {
        return products;
    }
    public void setProducts(ProductFormData products) {
        this.products = products;
    }
    public List<Object> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<Object> productImages) {
        this.productImages = productImages;
    }
    @Override
    public String toString() {
        return "ProductRequest [products=" + products + ", productImages=" + productImages + "]";
    }
    
}
