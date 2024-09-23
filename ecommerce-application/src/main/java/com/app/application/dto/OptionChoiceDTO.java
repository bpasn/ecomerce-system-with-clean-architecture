package com.app.application.dto;


public class OptionChoiceDTO {
    private String name;
    private String choiceEffect;
    private double price;
    private String status;

    public OptionChoiceDTO() {
    }
    public OptionChoiceDTO(String name, String choiceEffect, double price, String status) {
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "OptionChoiceDTO [name=" + name + ", choiceEffect=" + choiceEffect + ", price=" + price + ", status="
                + status + "]";
    }

    
    
}
