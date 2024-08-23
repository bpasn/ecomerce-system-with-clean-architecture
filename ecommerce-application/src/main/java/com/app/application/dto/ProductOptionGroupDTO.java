package com.app.application.dto;

import java.util.List;

public class ProductOptionGroupDTO {
    String groupName;
    boolean isRequired;
    List<ProductOptionDTO> productOptions;
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public boolean isRequired() {
        return isRequired;
    }
    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
    
    public List<ProductOptionDTO> getProductOptions() {
        return productOptions;
    }
    public void setProductOptions(List<ProductOptionDTO> productOptions) {
        this.productOptions = productOptions;
    }

    @Override
    public String toString() {
        return "ProductOptionGroupDTO [groupName=" + groupName + ", isRequired=" + isRequired + ", productOptions=" + productOptions + "]";
    }
    
}
