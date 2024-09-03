package com.app.application.dto;

import java.util.UUID;

public class StoreDTO {
    private UUID id;
    private String storeName;
    

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
