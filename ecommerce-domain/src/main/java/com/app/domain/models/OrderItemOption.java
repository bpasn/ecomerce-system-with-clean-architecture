package com.app.domain.models;

import java.util.ArrayList;
import java.util.List;

public class OrderItemOption extends BaseModel {
    private OrderItem orderItem;

    private ProductOption productOption;

    private List<OrderItemOptionChoice> orderItemOptionChoice = new ArrayList<>();

    public OrderItemOption() {
    }

    public OrderItemOption(OrderItem orderItem, ProductOption productOption, List<OrderItemOptionChoice> orderItemOptionChoice) {
        this.orderItem = orderItem;
        this.productOption = productOption;
        this.orderItemOptionChoice = orderItemOptionChoice;
    }
    public OrderItemOption(ProductOption productOption, List<OrderItemOptionChoice> orderItemOptionChoice) {
        this.productOption = productOption;
        this.orderItemOptionChoice = orderItemOptionChoice;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public ProductOption getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOption productOption) {
        this.productOption = productOption;
    }

    public List<OrderItemOptionChoice> getOrderItemOptionChoice() {
        return orderItemOptionChoice;
    }

    public void setOrderItemOptionChoice(List<OrderItemOptionChoice> orderItemOptionChoice) {
        this.orderItemOptionChoice = orderItemOptionChoice;
    }
}