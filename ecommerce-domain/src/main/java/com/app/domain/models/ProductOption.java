package com.app.domain.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ProductOption extends BaseModel {

    private String optionName;

    private boolean oneMustBeChosen;

    private boolean manyCanBeChosen;

    private int lengthSelect;

    private Store store;
    
    private Set<OptionChoice> choices = new HashSet<>();

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
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        setId(id);
        this.optionName = optionName;
        this.oneMustBeChosen = oneMustBeChosen;
        this.manyCanBeChosen = manyCanBeChosen;
        this.lengthSelect = lengthSelect;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public ProductOption(
            String id,
            String optionName,
            boolean oneMustBeChosen,
            boolean manyCanBeChosen,
            Set<OptionChoice> choices,
            int lengthSelect,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        setId(id);
        this.optionName = optionName;
        this.oneMustBeChosen = oneMustBeChosen;
        this.manyCanBeChosen = manyCanBeChosen;
        this.choices = choices;
        this.lengthSelect = lengthSelect;
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
    public Set<OptionChoice> getChoices() {
        return choices;
    }

    public void setChoices(Set<OptionChoice> choices) {
        this.choices = choices;
    }
    @Override
    public String toString() {
        return "ProductOption [optionName=" + optionName + ", oneMustBeChosen=" + oneMustBeChosen + ", manyCanBeChosen="
                + manyCanBeChosen + ", lengthSelect=" + lengthSelect + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

   

}
