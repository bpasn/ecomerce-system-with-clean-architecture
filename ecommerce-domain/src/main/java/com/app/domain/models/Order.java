package com.app.domain.models;

import com.app.domain.enums.EOrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseModel {
    private EOrderStatus orderStatus;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(Double totalAmount, EOrderStatus orderStatus) {
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
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
        return "Order [id=" +getId()+ ",  orderStatus=" + orderStatus + ", totalAmount=" + totalAmount + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }
    
    
    
    
}
