package com.app.application.dto;


public class ProductGroupDTO {
    String groupName;
    boolean isRequired;
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


    @Override
    public String toString() {
        return "ProductOptionGroupDTO [groupName=" + groupName + ", isRequired=" + isRequired  + "]";
    }
    
}
