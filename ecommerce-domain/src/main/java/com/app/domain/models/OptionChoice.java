package com.app.domain.models;

public class OptionChoice extends BaseModel {

    private ProductOption productOption;
    
    private String name;
    private EChoiceEffect choiceEffect;
    private double price;
    private EStatusChoice status;
    
    public OptionChoice() {
        setStatus(EStatusChoice.available);
    }
    public OptionChoice(String name, EChoiceEffect choiceEffect, double price, EStatusChoice status) {
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
    public ProductOption getProductOption() {
        return productOption;
    }
    public void setProductOption(ProductOption productOption) {
        this.productOption = productOption;
    }
    
    

}
