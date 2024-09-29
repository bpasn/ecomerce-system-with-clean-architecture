package com.app.application.dto;

public class ProductImageDTO {
    private String source;
    private String id;

    public ProductImageDTO(){}
    public ProductImageDTO(String id, String source) {
        this.source = source;
        this.id = id;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
