package com.app.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name="order_item_option_choice")
public class OrderItemOptionChoiceEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_item_option_id", nullable = false, referencedColumnName = "id")
    private OrderItemOptionEntity orderItemOption;

    @ManyToOne
    @JoinColumn(name = "option_choice_id", nullable = false, referencedColumnName = "id")
    private OptionChoiceEntity optionChoice;

    public OrderItemOptionEntity getOrderItemOption() {
        return orderItemOption;
    }

    public void setOrderItemOption(OrderItemOptionEntity orderItemOption) {
        this.orderItemOption = orderItemOption;
    }

    public OptionChoiceEntity getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(OptionChoiceEntity optionChoice) {
        this.optionChoice = optionChoice;
    }




}