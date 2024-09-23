package com.app.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Store extends BaseModel {
    private String storeName;

    private User user;

    private List<Product> products = new ArrayList<>();

    private List<ProductCategories> productCategories = new ArrayList<>();

    private List<ProductOption> productOption = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Store() {
    }

    public Store(
            String id,
            String storeName,
            User user,
            List<Product> products,
            List<ProductCategories> productCategories,
            List<ProductOption> productOption,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        setId(id);
        this.storeName = storeName;
        this.user = user;
        this.products = products;
        this.productCategories = productCategories;
        this.productOption = productOption;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ProductCategories> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategories> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductOption> getProductOption() {
        return productOption;
    }

    public void setProductOption(List<ProductOption> productOption) {
        this.productOption = productOption;
    }

    @Override
    public String toString() {
        return "Store [storeName=" + storeName + ", user=" + user.toString() + ", products=" + products
                + ", productCategories="
                + productCategories + ", productOption=" + productOption + "]";
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
