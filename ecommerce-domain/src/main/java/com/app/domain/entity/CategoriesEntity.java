package com.app.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.domain.usecase.CategoryUseCase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity {
    @Column(name = "name",unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = false)
    private LocalDateTime updatedAt;

    
    public CategoriesEntity(){}
    public CategoriesEntity(String name) {
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
    
    public void validateCategoryNameExists(CategoryUseCase c){
        if(c.isExistsName(this.name)){
            throw new CustomExceptionHandler("Category Name with '"+name+"' already exists",EnumCode.BAD_REQUEST);
        }
    }
    
}
