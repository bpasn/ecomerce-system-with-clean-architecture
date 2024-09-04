package com.app.ecommerce.api.request;

import java.util.List;

import com.app.application.dto.StockDTO;

public class ProductFormData {
    String nameTH;
    String nameEN;
    String descriptionTH;
    String descriptionEN;
    double price;
    int quantity;
    StockDTO stock;
    List<String> categories;
    List<String> productOptions;
    public String getNameTH() {
        return nameTH;
    }
    public void setNameTH(String nameTH) {
        this.nameTH = nameTH;
    }
    public String getNameEN() {
        return nameEN;
    }
    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }
    public String getDescriptionTH() {
        return descriptionTH;
    }
    public void setDescriptionTH(String descriptionTH) {
        this.descriptionTH = descriptionTH;
    }
    public String getDescriptionEN() {
        return descriptionEN;
    }
    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public StockDTO getStock() {
        return stock;
    }
    public void setStock(StockDTO stock) {
        this.stock = stock;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    public List<String> getProductOptions() {
        return productOptions;
    }
    public void setProductOptions(List<String> productOptions) {
        this.productOptions = productOptions;
    }
    @Override
    public String toString() {
        return "ProductFormData [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", quantity=" + quantity + ", stock="
                + stock + ", categories=" + categories + ", productOptions=" + productOptions + "]";
    }
    
    
}
