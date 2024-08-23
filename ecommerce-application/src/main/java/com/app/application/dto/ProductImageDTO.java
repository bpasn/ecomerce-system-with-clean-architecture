package com.app.application.dto;


public class ProductImageDTO{
    String source;
    String type;
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "ProductImageDTO [source=" + source + ", type=" + type + "]";
    }

    
}
