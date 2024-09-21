package com.app.domain.models;

import java.util.ArrayList;
import java.util.List;

import com.app.domain.exceptions.DomainException;
import com.app.domain.usecase.ProductCategoryUseCase;

public class ProductCategories extends BaseModel {
    private String name;

    private Store store;
    
    private List<Product> products = new ArrayList<>();
    
    public ProductCategories(){}
    public ProductCategories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void validateCategoryNameExists(ProductCategoryUseCase c){
        if(c.isExistsName(this.name)){
            throw new DomainException("Category Name with '"+name+"' already exists");
        }
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    
}
