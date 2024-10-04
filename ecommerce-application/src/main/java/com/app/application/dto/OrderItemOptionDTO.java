package com.app.application.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderItemOptionDTO {
    private String id;
    private ProductOptionDTO productOption;
    private List<OrderItemOptionChoiceDTO> orderItemOptionChoice = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductOptionDTO getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOptionDTO productOption) {
        this.productOption = productOption;
    }

    public List<OrderItemOptionChoiceDTO> getOrderItemOptionChoice() {
        return orderItemOptionChoice;
    }

    public void setOrderItemOptionChoice(List<OrderItemOptionChoiceDTO> orderItemOptionChoice) {
        this.orderItemOptionChoice = orderItemOptionChoice;
    }


    @Override
    public String toString() {
        return "OrderItemOptionDTO{" +
                "id='" + id + '\'' +
                ", productOption=" + productOption.toString() +
                ", orderItemOptionChoice=" + orderItemOptionChoice.toString() +
                '}';
    }
}