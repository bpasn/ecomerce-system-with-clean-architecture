package com.app.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product extends BaseModel {
    private String nameTH;
    private String nameEN;
    private String descriptionTH;
    private String descriptionEN;
    private double price;

    private Stock stock;

    private Store store;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private List<ProductCategories> categories = new ArrayList<>();

    private List<ProductImage> productImages = new ArrayList<>();

    private List<ProductOption> productOptions = new ArrayList<>();

    public Product() {
    }

    public Product(String nameTH, String nameEN, String descriptionTH, String descriptionEN, double price,
            List<ProductCategories> categories,
            List<ProductImage> productImages) {
        this.nameTH = nameTH;
        this.nameEN = nameEN;
        this.descriptionTH = descriptionTH;
        this.descriptionEN = descriptionEN;
        this.price = price;
        this.categories = categories;
        this.productImages = productImages;
        // this.productGroups = productGroups;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<ProductCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategories> categories) {
        this.categories = categories;
    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }

    

    @Override
    public String toString() {
        return "Product [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", stock=" + stock + ", store=" + store
                + ", categories=" + categories + ", productImages=" + productImages + ", productOptions="
                + productOptions + "]";
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
