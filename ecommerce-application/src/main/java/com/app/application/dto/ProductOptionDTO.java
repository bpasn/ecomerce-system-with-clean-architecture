package com.app.application.dto;

import java.util.List;

public class ProductOptionDTO {
    private String optionName;
    private boolean oneMustBeChosen;
    private boolean manyCanBeChosed;
    private int lengthSelect;
    private List<OptionChoiceDTO> choices;

    public ProductOptionDTO() {
        setOneMustBeChosen(false);
        setManyCanBeChosed(false);
    }

    public ProductOptionDTO(
            String optionName,
            boolean oneMustBeChosen,
            boolean manyCanBeChosed,
            int lengthSelect,
            List<OptionChoiceDTO> choices) {
        this.optionName = optionName;
        this.oneMustBeChosen = oneMustBeChosen;
        this.manyCanBeChosed = manyCanBeChosed;
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

    public boolean isManyCanBeChosed() {
        return manyCanBeChosed;
    }

    public void setManyCanBeChosed(boolean manyCanBeChosed) {
        this.manyCanBeChosed = manyCanBeChosed;
    }

    public int getLengthSelect() {
        return lengthSelect;
    }

    public void setLengthSelect(int lengthSelect) {
        this.lengthSelect = lengthSelect;
    }

    public List<OptionChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<OptionChoiceDTO> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ProductOptionDTO [optionName=" + optionName + ", oneMustBeChosen=" + oneMustBeChosen
                + ", manyCanBeChosed=" + manyCanBeChosed + ", lengthSelect=" + lengthSelect + ", choices=" + choices
                + "]";
    }

}
