package com.app.application.dto;


public class CategoriesDTO {
    private String id;
    private String name;
    private String storeId;

    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    public CategoriesDTO(){}
    
    public CategoriesDTO(String id, String name, String storeId) {
        this.id = id;
        this.name = name;
        this.storeId = storeId;
    }
    public CategoriesDTO(String id){
        setId(id);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoriesDTO [name=" + name + "]";
    }
    
    
}