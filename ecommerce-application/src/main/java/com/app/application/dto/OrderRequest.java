package com.app.application.dto;

import java.util.HashSet;
import java.util.Set;

public class OrderRequest {
    private Double totalAmount;
    private Set<OrderItemObject> orderItems = new HashSet<>();
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Set<OrderItemObject> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItemObject> orderItems) {
        this.orderItems = orderItems;
    }
    @Override
    public String toString() {
        return "OrderRequest [totalAmount=" + totalAmount + ", orderItems=" + orderItems + "]";
    }

    

    

}