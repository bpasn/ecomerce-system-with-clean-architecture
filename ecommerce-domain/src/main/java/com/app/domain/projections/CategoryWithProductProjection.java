package com.app.domain.projections;
import java.util.List;

import com.app.domain.models.Product;
public class CategoryWithProductProjection {
    private String categoryId;
    private String categoryName;
    private List<Product> products;
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    
}
