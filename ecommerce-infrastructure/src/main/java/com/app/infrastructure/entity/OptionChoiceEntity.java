package com.app.infrastructure.entity;

import java.math.BigDecimal;

import com.app.domain.models.EChoiceEffect;
import com.app.domain.models.EStatusChoice;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "option_choice")
public class OptionChoiceEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_option_id",nullable = false)
    @JsonIgnore
    private ProductOptionEntity productOption;
    
    private String name;
    @Enumerated(EnumType.STRING)
    private EChoiceEffect choiceEffect;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private EStatusChoice status;
    
    public OptionChoiceEntity() {
        this.status = EStatusChoice.available;
    }
    public OptionChoiceEntity(String name, EChoiceEffect choiceEffect, BigDecimal price, EStatusChoice status) {
        this.name = name;
        this.choiceEffect = choiceEffect;
        this.price = price;
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public EChoiceEffect getChoiceEffect() {
        return choiceEffect;
    }
    public void setChoiceEffect(EChoiceEffect choiceEffect) {
        this.choiceEffect = choiceEffect;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public EStatusChoice getStatus() {
        return status;
    }
    public void setStatus(EStatusChoice status) {
        this.status = status;
    }
    public ProductOptionEntity getProductOption() {
        return productOption;
    }
    public void setProductOption(ProductOptionEntity productOption) {
        this.productOption = productOption;
    }
    @Override
    public String toString() {
        return "OptionChoiceEntity [productOption=" + productOption + ", name=" + name + ", choiceEffect="
                + choiceEffect + ", price=" + price + ", status=" + status + "]";
    }
    

    
    

}
