package com.app.domain.models;

import java.time.LocalDateTime;

import com.app.domain.exceptions.DomainException;
import com.app.domain.usecase.ProductCategoryUseCase;

public class ProductCategories extends BaseModel {
    private String name;

    private Store store;

    // private Set<Product> products = new HashSet<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductCategories() {
    }

    public ProductCategories(String id,String name,Store store){
        setId(id);
        this.name = name;
        this.store = store;
    }

    public ProductCategories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Set<Product> getProducts() {
    //     return products;
    // }

    // public void setProducts(Set<Product> products) {
    //     this.products = products;
    // }

    public void validateCategoryNameExists(ProductCategoryUseCase c) {
        if (c.isExistsName(this.name)) {
            throw new DomainException("Category Name with '" + name + "' already exists");
        }
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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

    @Override
    public String toString() {
        return "ProductCategories [name=" + name +  "]";
    }

    

}
