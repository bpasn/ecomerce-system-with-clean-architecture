package com.app.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "option_choice")
public class OptionChoiceEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_option_id",nullable = false)
    private ProductOptionEntity productOption;
    
    private String name;
    @Enumerated(EnumType.STRING)
    private EChoiceEffect choiceEffect;
    private double price;
    @Enumerated(EnumType.STRING)
    private EStatusChoice status;
    
    public OptionChoiceEntity() {
        setStatus(EStatusChoice.available);
    }
    public OptionChoiceEntity(String name, EChoiceEffect choiceEffect, double price, EStatusChoice status) {
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
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
    
    

}
