package com.app.application.dto;

import java.util.List;

public class ProductsDTO {
    String name;
    String description;
    double price;
    int quantity;
    StockDTO stocks;

    public StockDTO getStocks() {
        return stocks;
    }
    public void setStocks(StockDTO stocks) {
        this.stocks = stocks;
    }
    List<CategoriesDTO> categories;
    List<ProductImageDTO> productImages;
    List<ProductGroupDTO> productOptionGroups;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    
    public List<CategoriesDTO> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoriesDTO> categories) {
        this.categories = categories;
    }
    public List<ProductImageDTO> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<ProductImageDTO> productImages) {
        this.productImages = productImages;
    }
    public List<ProductGroupDTO> getProductOptionGroups() {
        return productOptionGroups;
    }
    public void setProductOptionGroups(List<ProductGroupDTO> productOptionGroups) {
        this.productOptionGroups = productOptionGroups;
    }
    @Override
    public String toString() {
        return "ProductsDTO [name=" + name + ", description=" + description + ", price=" + price + ", quantity="
                + quantity + ", categories=" + categories.toString() + ", productImages=" + productImages.toString()
                + ", productOptionGroups=" + productOptionGroups.toString() + "]";
    }

    
}
