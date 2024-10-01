package com.app.application.dto;

public class OrderItemDTO {
    private String id;
    private ProductsDTO product;
    private int quantity;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ProductsDTO getProduct() {
        return product;
    }
    public void setProduct(ProductsDTO product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    
}
