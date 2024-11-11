package com.app.domain.models;

import com.app.domain.enums.EChoiceEffect;
import com.app.domain.enums.EStatusChoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OptionChoice extends BaseModel {

    private ProductOption productOption;

    private String name;

    private EChoiceEffect choiceEffect;

    private BigDecimal price;

    private EStatusChoice status;
    
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    
    
    public OptionChoice() {
        setStatus(EStatusChoice.available);
    }
    
    public OptionChoice(String id,String name, EChoiceEffect choiceEffect, BigDecimal price, EStatusChoice status) {
        setId(id);
        this.name = name;
        this.choiceEffect = choiceEffect;
        this.price = price;
        this.status = status;
    }
    public OptionChoice(String name, EChoiceEffect choiceEffect, BigDecimal price, EStatusChoice status) {
        this.name = name;
        this.choiceEffect = choiceEffect;
        this.price = price;
        this.status = status;
    }

    public ProductOption getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOption productOption) {
        this.productOption = productOption;
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
   
    

}
