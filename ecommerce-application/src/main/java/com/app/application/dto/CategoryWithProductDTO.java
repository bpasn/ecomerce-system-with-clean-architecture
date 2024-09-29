package com.app.application.dto;
import java.util.List;
public class CategoryWithProductDTO {
    private String categoryName;
    private String categoryId;
    private List<ProductsDTO> products;
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public List<ProductsDTO> getProducts() {
        return products;
    }
    public void setProducts(List<ProductsDTO> products) {
        this.products = products;
    }

    
}
