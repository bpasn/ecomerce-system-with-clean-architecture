package com.app.ecommerce.api.request.product;

import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import com.app.application.dto.StockDTO;

public class ProductRequest {
    @NotNull
    ProductFormData product;
    @NotNull
    StockDTO stock;
    @NotNull
    @Size(min = 1, message = "categories have at least one file")
    Set<String> categories;
    Set<String> productOptions;
    @NotNull(message = "Product image cannot be null")
    @Size(min = 1, message = "ProductImage have at least one file")
    List<MultipartFile> productImages;

    public ProductFormData getProduct() {
        return product;
    }
    public void setProduct(ProductFormData product) {
        this.product = product;
    }
    public StockDTO getStock() {
        return stock;
    }
    public void setStock(StockDTO stock) {
        this.stock = stock;
    }
    public Set<String> getCategories() {
        return categories;
    }
    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
    public Set<String> getProductOptions() {
        return productOptions;
    }
    public void setProductOptions(Set<String> productOptions) {
        this.productOptions = productOptions;
    }
  
    public List<MultipartFile> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }

   
}
