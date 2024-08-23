package com.app.application.dto;

public class ProductOptionDTO {
    String optionName;
    double price;
    public String getOptionName() {
        return optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "ProductOptionDTO [optionName=" + optionName + ", price=" + price +"]";
    }

    
}
