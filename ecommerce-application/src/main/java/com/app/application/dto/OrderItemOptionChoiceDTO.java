package com.app.application.dto;

public class OrderItemOptionChoiceDTO {
    private String id;
    private OptionChoiceDTO optionChoice;

    public OrderItemOptionChoiceDTO(){}
    public OrderItemOptionChoiceDTO(String id) {
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OptionChoiceDTO getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(OptionChoiceDTO optionChoice) {
        this.optionChoice = optionChoice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderItemOptionChoiceDTO{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }


    
}