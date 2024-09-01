package com.app.ecommerce.api.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class ProductRequest {
    private List<MultipartFile> productImages;
    private String products;
    public List<MultipartFile> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }
    public String getProducts() {
        return products;
    }
    public void setProducts(String products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "ProductRequest [productImages=" + productImages + ", products=" + products + "]";
    }
   


    

}
