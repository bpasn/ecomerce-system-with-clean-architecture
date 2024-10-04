package com.app.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="order_item_option")
public class OrderItemOptionEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false, referencedColumnName = "id")
    private OrderItemEntity orderItem;

    @ManyToOne
    @JoinColumn(name = "product_option_id", referencedColumnName="id")
    private ProductOptionEntity productOption;

    @OneToMany(mappedBy = "orderItemOption")
    private List<OrderItemOptionChoiceEntity> orderItemOptionChoice = new ArrayList<>();

    public OrderItemEntity getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemEntity orderItem) {
        this.orderItem = orderItem;
    }

    public ProductOptionEntity getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOptionEntity productOption) {
        this.productOption = productOption;
    }

    public List<OrderItemOptionChoiceEntity> getOrderItemOptionChoice() {
        return orderItemOptionChoice;
    }

    public void setOrderItemOptionChoice(List<OrderItemOptionChoiceEntity> orderItemOptionChoice) {
        this.orderItemOptionChoice = orderItemOptionChoice;
    }



}
