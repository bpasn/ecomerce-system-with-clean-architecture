package com.app.application.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductOptionDTO {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String optionName;
    private boolean oneMustBeChosen;
    private boolean manyCanBeChosen;
    private int lengthSelect;
    private Set<OptionChoiceDTO> choices = new HashSet<>();
    private String storeId;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public ProductOptionDTO() {
        setOneMustBeChosen(false);
        setManyCanBeChosen(false);
    }

    public ProductOptionDTO(String id){
        setId(id);
    }
    public ProductOptionDTO(
            String optionName,
            boolean oneMustBeChosen,
            boolean manyCanBeChosen,
            int lengthSelect,
            Set<OptionChoiceDTO> choices) {
        this.optionName = optionName;
        this.oneMustBeChosen = oneMustBeChosen;
        this.manyCanBeChosen = manyCanBeChosen;
        this.lengthSelect = lengthSelect;
        this.choices = choices;
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

    public Set<OptionChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(Set<OptionChoiceDTO> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ProductOptionDTO [id = " + id + ", optionName=" + optionName + ", oneMustBeChosen=" + oneMustBeChosen
                + ", manyCanBeChosen=" + manyCanBeChosen + ", lengthSelect=" + lengthSelect + ", choices=" + choices.toString()
                + "]";
    }

}
