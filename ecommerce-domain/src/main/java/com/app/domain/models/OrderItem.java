package com.app.domain.models;

import java.util.ArrayList;
import java.util.List;

public class OrderItem extends BaseModel {

    private Product product;
    private Order order;
    private List<OrderItemOption> orderItemOptions = new ArrayList<>();
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItemOption> getOrderItemOptions() {
        return orderItemOptions;
    }

    public void setOrderItemOptions(List<OrderItemOption> orderItemOption) {
        this.orderItemOptions = orderItemOption;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
