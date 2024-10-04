package com.app.application.dto;

import java.math.BigDecimal;

public class OptionChoiceDTO {
    private String id;
    private String name;
    private String choiceEffect;
    private BigDecimal price;
    private String status;

    public OptionChoiceDTO() {
    }
    public OptionChoiceDTO(String id) {
        this.id = id;
    }
    public OptionChoiceDTO(String id,String name, String choiceEffect, BigDecimal price, String status) {
        this.id = id;
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
    public String getChoiceEffect() {
        return choiceEffect;
    }
    public void setChoiceEffect(String choiceEffect) {
        this.choiceEffect = choiceEffect;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "OptionChoiceDTO [name=" + name + ", choiceEffect=" + choiceEffect + ", price=" + price + ", status="
                + status + "]";
    }
    

    
    
}
