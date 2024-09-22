package com.app.infrastructure.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "product_images")
public class ProductImageEntity extends BaseEntity {
    @Column(name = "source")
    private String source;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public ProductImageEntity() {

    }

    public ProductImageEntity(String source) {
        this.source = source;
    }
    public ProductImageEntity(String id,String source) {
        setId(id);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

}
