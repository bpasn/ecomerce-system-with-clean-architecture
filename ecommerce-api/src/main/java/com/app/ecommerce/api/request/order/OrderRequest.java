package com.app.ecommerce.api.request.order;

import java.util.ArrayList;
import java.util.List;

import com.app.domain.enums.EOrderStatus;

public class OrderRequest {
    private Double totalAmount;
    private EOrderStatus orderStatus;
    private List<OrderItemRequest> orderItems = new ArrayList<>();

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
