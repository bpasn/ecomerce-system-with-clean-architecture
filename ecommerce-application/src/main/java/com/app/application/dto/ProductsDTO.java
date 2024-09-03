package com.app.application.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductsDTO {
    String nameTH;
    String nameEN;
    String descriptionTH;
    String descriptionEN;
    double price;
    int quantity;
    StockDTO stock;
    List<MultipartFile> productImages;
    List<CategoriesDTO> categoriesDTOs;
    List<ProductOptionDTO> productOptions;

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

    public List<MultipartFile> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public String getNameTH() {
        return nameTH;
    }

    public void setNameTH(String nameTH) {
        this.nameTH = nameTH;
    }

    public List<ProductOptionDTO> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptionDTO> productOptions) {
        this.productOptions = productOptions;
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



    public List<CategoriesDTO> getCategoriesDTOs() {
        return categoriesDTOs;
    }



    public void setCategoriesDTOs(List<CategoriesDTO> categoriesDTOs) {
        this.categoriesDTOs = categoriesDTOs;
    }



    @Override
    public String toString() {
        return "ProductsDTO [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", quantity=" + quantity + ", stock="
                + stock + ", productImages=" + productImages + ", categoriesDTOs=" + categoriesDTOs
                + ", productOptions=" + productOptions + "]";
    }


    
    

}
