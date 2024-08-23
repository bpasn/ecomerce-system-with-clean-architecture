package com.app.application.dto;


public class CategoriesDTO{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoriesDTO [name=" + name + "]";
    }
    
    
}