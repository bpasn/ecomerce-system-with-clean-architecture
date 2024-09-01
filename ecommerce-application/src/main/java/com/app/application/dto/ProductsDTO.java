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
    List<ProductGroupDTO> productGroups;
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

    // public List<CategoriesDTO> getCategories() {
    // return categories;
    // }
    // public void setCategories(List<CategoriesDTO> categories) {
    // this.categories = categories;
    // }
    public List<MultipartFile> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }

    @Override
    public String toString() {
        return "ProductsDTO [name=" + nameTH + ", descriptionTH=" + descriptionTH + "descriptionEN" + descriptionEN + ", price="
                + price + ", quantity="
                + quantity + ", productImages=" + productImages.toString() + "]";
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

    public List<ProductGroupDTO> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(List<ProductGroupDTO> productGroups) {
        this.productGroups = productGroups;
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

    

}
