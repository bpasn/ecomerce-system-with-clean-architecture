package com.app.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

import com.app.domain.enums.EOrderStatus;

import jakarta.persistence.*;

@Entity(name = "orders")
public class OrderEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    private Double totalAmount;

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    
}
