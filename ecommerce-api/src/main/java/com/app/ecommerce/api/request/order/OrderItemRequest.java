package com.app.ecommerce.api.request.order;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRequest {
    private String productId;
    private int quantity;
    private List<OrderOptionChoiceRequest> options = new ArrayList<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderOptionChoiceRequest> getOptions() {
        return options;
    }

    public void setOptions(List<OrderOptionChoiceRequest> options) {
        this.options = options;
    }

    
}
