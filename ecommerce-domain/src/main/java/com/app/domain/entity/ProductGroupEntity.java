package com.app.domain.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.app.domain.exceptions.DomainException;
import com.app.domain.usecase.ProductGroupUseCase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "product_groups")
public class ProductGroupEntity extends BaseEntity {
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "is_required")
    private boolean isRequired;

    // @ManyToMany(mappedBy = "productGroups")
    // private List<ProductEntity> products = new ArrayList<>();

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    // public List<ProductEntity> getProducts() {
    // return products;
    // }

    // public void setProducts(List<ProductEntity> products) {
    // this.products = products;
    // }

    @Override
    public String toString() {
        return "ProductGroupEntity [groupName=" + groupName + ", isRequired=" + isRequired + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

    public void validateGroupNameUnique(ProductGroupUseCase pu) {
        if (pu.isGroupNameExists(this.groupName)) {
            throw new DomainException("ProductGroup with name " + this.groupName + " already exists");
        }
    }

}
