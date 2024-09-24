package com.app.ecommerce.api.request;

import java.util.List;
import java.util.Set;

import com.app.application.dto.StockDTO;

public class ProductFormData {
    String nameTH;
    String nameEN;
    String descriptionTH;
    String descriptionEN;
    double price;
    int quantity;
    StockDTO stock;
    Set<String> categories;
    Set<String> productOptions;
    String storeId;
    
    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
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
    public Set<String> getCategories() {
        return categories;
    }
    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
    public Set<String> getProductOptions() {
        return productOptions;
    }
    public void setProductOptions(Set<String> productOptions) {
        this.productOptions = productOptions;
    }
    @Override
    public String toString() {
        return "ProductFormData [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", quantity=" + quantity + "]";
    }
   
    
    
}
