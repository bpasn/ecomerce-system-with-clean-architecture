package com.app.application.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.app.domain.enums.EOrderStatus;

public class OrderDTO {

    private String id;
    private String orderId;
    private EOrderStatus orderStatus;
    private List<OrderItemDTO> orderItems = new ArrayList<>();
    private Double totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDTO [id=" + id + ", orderStatus=" + orderStatus + ", orderItems=" + orderItems + ", totalAmount="
                + totalAmount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
