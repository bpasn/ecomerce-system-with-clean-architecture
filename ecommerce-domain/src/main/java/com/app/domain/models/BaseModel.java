package com.app.domain.models;

import java.time.LocalDateTime;

public class BaseModel {
    private String id;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    
}
