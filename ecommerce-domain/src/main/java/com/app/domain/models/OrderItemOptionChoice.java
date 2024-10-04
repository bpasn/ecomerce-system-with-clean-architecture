package com.app.domain.models;

public class OrderItemOptionChoice extends BaseModel {
    private OrderItemOption orderItemOption;
    private OptionChoice optionChoice;

    public OrderItemOptionChoice() {
    }
    public OrderItemOptionChoice(String id,OptionChoice optionChoice) {
        setId(id);
    this.optionChoice = optionChoice;
    }

    public OrderItemOptionChoice(OrderItemOption orderItemOption,OptionChoice optionChoice) {
        this.orderItemOption = orderItemOption;
        this.optionChoice = optionChoice;
    }

    public OptionChoice getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(OptionChoice optionChoice) {
        this.optionChoice = optionChoice;
    }

    public OrderItemOption getOrderItemOption() {
        return orderItemOption;
    }

    public void setOrderItemOption(OrderItemOption orderItemOption) {
        this.orderItemOption = orderItemOption;
    }
}