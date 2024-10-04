package com.app.application.dto;

import java.math.BigDecimal;
import java.util.Set;

public class ProductsDTO {
    String id;
    String nameTH;
    String nameEN;
    String descriptionTH;
    String descriptionEN;
    BigDecimal price;
    int quantity;
    StockDTO stock;
    Set<ProductImageDTO> productImages;
    Set<CategoriesDTO> categories;
    Set<ProductOptionDTO> productOptions;
    String storeId;

    public ProductsDTO(){}
    public ProductsDTO(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<ProductImageDTO> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImageDTO> productImages) {
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

    public Set<ProductOptionDTO> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(Set<ProductOptionDTO> productOptions) {
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

    public Set<CategoriesDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductsDTO [nameTH=" + nameTH + ", nameEN=" + nameEN + ", descriptionTH=" + descriptionTH
                + ", descriptionEN=" + descriptionEN + ", price=" + price + ", quantity=" + quantity + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
