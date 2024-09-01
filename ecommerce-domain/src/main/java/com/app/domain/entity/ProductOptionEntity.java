package com.app.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity(name = "product_options")
public class ProductOptionEntity extends BaseEntity {
    @Column(name = "option_name")
    private String optionName;

    @Column(name = "one_must_be_chosen", columnDefinition = "boolean default false")
    private boolean oneMustBeChosen;

    @Column(name = "many_can_be_chosen",columnDefinition = "boolean default false")
    private boolean manyCanBeChosen;

    @Column(nullable = true)
    private int lengthSelect;

    @OneToMany(mappedBy = "productOption")
    private List<OptionChoiceEntity> choices = new ArrayList<>();

    @ManyToMany(mappedBy = "productOptions")
    private List<ProductEntity> products = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    public ProductOptionEntity() {
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
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

    public boolean isOneMustBeChosen() {
        return oneMustBeChosen;
    }

    public void setOneMustBeChosen(boolean oneMustBeChosen) {
        this.oneMustBeChosen = oneMustBeChosen;
    }

    public boolean isManyCanBeChosen() {
        return manyCanBeChosen;
    }

    public void setManyCanBeChosen(boolean manyCanBeChosen) {
        this.manyCanBeChosen = manyCanBeChosen;
    }

    public int getLengthSelect() {
        return lengthSelect;
    }

    public void setLengthSelect(int lengthSelect) {
        this.lengthSelect = lengthSelect;
    }

    public List<OptionChoiceEntity> getChoices() {
        return choices;
    }

    public void setChoices(List<OptionChoiceEntity> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ProductOptionEntity [optionName=" + optionName + ", products="
                + products.toString()
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
