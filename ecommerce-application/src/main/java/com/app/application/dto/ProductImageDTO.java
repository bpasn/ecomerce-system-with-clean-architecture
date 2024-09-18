package com.app.application.dto;

public class ProductImageDTO {
    private String uri;
    private String id;

    public ProductImageDTO(String id, String uri) {
        this.uri = uri;
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductImageDTO [uri=" + uri + ", id=" + id + "]";
    }

}
