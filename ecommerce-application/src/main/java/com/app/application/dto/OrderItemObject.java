package com.app.application.dto;


public class OrderItemObject {
    private String productId;
    private int quantity;
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "OrderItemObject [productId=" + productId + ", quantity=" + quantity + "]";
    }

    

}
