package com.app.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "store")
public class StoreEntity extends BaseEntity {
    private String storeName;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategoriesEntity> productCategories = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOptionEntity> productOption = new ArrayList<>();

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public List<ProductCategoriesEntity> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategoriesEntity> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductOptionEntity> getProductOption() {
        return productOption;
    }

    public void setProductOption(List<ProductOptionEntity> productOption) {
        this.productOption = productOption;
    }

    @Override
    public String toString() {
        return "StoreEntity [storeName=" + storeName + ", user=" + user + ", products=" + products
                + ", productCategories=" + productCategories + ", productOption=" + productOption + "]";
    }
    
    
}
