package com.app.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductOption extends BaseModel {

    private String optionName;

    private boolean oneMustBeChosen;

    private boolean manyCanBeChosen;

    private int lengthSelect;

    private List<OptionChoice> choices = new ArrayList<>();

    private List<Product> products = new ArrayList<>();

    private Store store;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductOption() {
    }

    public ProductOption(
            String id,
            String optionName,
            boolean oneMustBeChosen,
            boolean manyCanBeChosen,
            int lengthSelect,
            List<OptionChoice> choices,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        setId(id);
        this.optionName = optionName;
        this.oneMustBeChosen = oneMustBeChosen;
        this.manyCanBeChosen = manyCanBeChosen;
        this.lengthSelect = lengthSelect;
        this.choices = choices;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public boolean isOneMustBeChosen() {
        return oneMustBeChosen;
    }

    public void setOneMustBeChosen(boolean oneMustBeChosen) {
        this.oneMustBeChosen = oneMustBeChosen;
    }

    public boolean isManyCanBeChosen() {
        return manyCanBeChosen;
    }

    public void setManyCanBeChosen(boolean manyCanBeChosen) {
        this.manyCanBeChosen = manyCanBeChosen;
    }

    public int getLengthSelect() {
        return lengthSelect;
    }

    public void setLengthSelect(int lengthSelect) {
        this.lengthSelect = lengthSelect;
    }

    public List<OptionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<OptionChoice> choices) {
        this.choices = choices;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductOption [optionName=" + optionName + ", oneMustBeChosen=" + oneMustBeChosen + ", manyCanBeChosen="
                + manyCanBeChosen + ", lengthSelect=" + lengthSelect + ", choices=" + choices.toString() + ", products="
                + products
                + ", store=" + store.toString() + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
