package com.app.ecommerce.api.request.product;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductFormData {
    @Pattern(regexp = "^[\\u0E00-\\u0E7F]+$",message = "Only Thai characters are allowed")
    @NotNull(message = "NameTh must not be null")
    @NotEmpty
    String nameTH;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Only English characters are allowed")
    String nameEN;
    @Pattern(regexp = "^[\\u0E00-\\u0E7F]+$",message = "Only Thai characters are allowed")
    String descriptionTH;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Only English characters are allowed")
    String descriptionEN;
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$",message = "Invalid format price")
    @NotEmpty
    double price;
    @NotNull(message = "Store id must not be null")
    @NotEmpty
    String storeId;
   
    
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
    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    @Override
    public String toString() {
        return "ProductFormData [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", storeId=" + storeId + "]";
    }
   
    
    
}
