package com.app.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Store extends BaseModel {
    private String storeName;

    private User user;

    private List<Product> products = new ArrayList<>();

    private List<ProductCategories> productCategories = new ArrayList<>();

    private List<ProductOption> productOption = new ArrayList<>();

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
        return "Store [storeName=" + storeName + ", user=" + user.toString() + ", products=" + products + ", productCategories="
                + productCategories + ", productOption=" + productOption + "]";
    }

    
    
}
