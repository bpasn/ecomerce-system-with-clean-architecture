package com.app.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "order_item")
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private ProductEntity product;

    private int quantity;

    @OneToMany(mappedBy="orderItem",cascade = CascadeType.ALL)
    private List<OrderItemOptionEntity> orderItemOptions = new ArrayList<>();

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderItemOptionEntity> getOrderItemOptions() {
        return orderItemOptions;
    }

    public void setOrderItemOptions(List<OrderItemOptionEntity> orderItemOptions) {
        this.orderItemOptions = orderItemOptions;
    }


    
}
