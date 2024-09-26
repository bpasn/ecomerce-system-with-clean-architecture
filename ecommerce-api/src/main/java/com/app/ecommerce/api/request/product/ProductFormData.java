package com.app.ecommerce.api.request.product;

public class ProductFormData {
    String nameTH;
    String nameEN;
    String descriptionTH;
    String descriptionEN;
    double price;
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
