package com.app.domain.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Order extends BaseModel {
    private EOrderStatus orderStatus;
    private Set<OrderItem> orderItems = new HashSet<>();
    private Double totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItem> orderItems) {
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
        return "Order [orderStatus=" + orderStatus + ", totalAmount=" + totalAmount + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }
    
    
    
    
}
