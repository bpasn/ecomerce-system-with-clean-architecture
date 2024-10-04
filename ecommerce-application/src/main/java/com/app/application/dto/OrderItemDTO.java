package com.app.application.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderItemDTO {
    private String id;
    private ProductsDTO product;
    private int quantity;
    private List<OrderItemOptionDTO> orderItemOptions = new ArrayList<>();

    public OrderItemDTO(String id) {
        this.id = id;
    }

    public OrderItemDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductsDTO getProduct() {
        return product;
    }

    public void setProduct(ProductsDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderItemOptionDTO> getOrderItemOptions() {
        return orderItemOptions;
    }

    public void setOrderItemOptions(List<OrderItemOptionDTO> orderItemOptions) {
        this.orderItemOptions = orderItemOptions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderItemDTO{");
        sb.append("id=").append(id);
        sb.append(", product=").append(product.toString());
        sb.append(", quantity=").append(quantity);
        sb.append(", orderItemOptions=").append(orderItemOptions.toString());
        sb.append('}');
        return sb.toString();
    }

    


}
