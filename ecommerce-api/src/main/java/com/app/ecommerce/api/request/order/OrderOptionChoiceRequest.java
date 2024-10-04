package com.app.ecommerce.api.request.order;

import java.util.ArrayList;
import java.util.List;

public class OrderOptionChoiceRequest {
    private String id;
    private List<String> choices = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

   
    
}