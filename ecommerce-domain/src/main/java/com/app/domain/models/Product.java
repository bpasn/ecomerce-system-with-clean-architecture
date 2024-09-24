package com.app.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Product extends BaseModel {
    private String nameTH;
    private String nameEN;
    private String descriptionTH;
    private String descriptionEN;
    private BigDecimal price;
    private Store store;
    private Stock stock;
    
    private Set<ProductCategories> categories = new HashSet<>();

    private Set<ProductImage> productImages = new HashSet<>();

    private Set<ProductOption> productOptions = new HashSet<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }


    public Product() {
    }

    public Product(String nameTH, String nameEN, String descriptionTH, String descriptionEN, BigDecimal price,
            Set<ProductCategories> categories,
            Set<ProductImage> productImages) {
        this.nameTH = nameTH;
        this.nameEN = nameEN;
        this.descriptionTH = descriptionTH;
        this.descriptionEN = descriptionEN;
        this.price = price;
        this.categories = categories;
        this.productImages = productImages;
        // this.productGroups = productGroups;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<ProductCategories> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategories> categories) {
        this.categories = categories;
    }

    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Set<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(Set<ProductOption> productOptions) {
        this.productOptions = productOptions;
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

    

    @Override
    public String toString() {
        return "Product [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
