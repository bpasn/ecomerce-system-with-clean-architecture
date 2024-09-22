package com.app.infrastructure.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.app.domain.exceptions.DomainException;
import com.app.domain.usecase.ProductCategoryUseCase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_categories")
public class ProductCategoriesEntity extends BaseEntity {
    @Column(name = "name",unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreEntity store;
    
    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();

    public ProductCategoriesEntity(){}
    public ProductCategoriesEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void validateCategoryNameExists(ProductCategoryUseCase c){
        if(c.isExistsName(this.name)){
            throw new DomainException("Category Name with '"+name+"' already exists");
        }
    }
    public StoreEntity getStore() {
        return store;
    }
    public void setStore(StoreEntity store) {
        this.store = store;
    }
    
}