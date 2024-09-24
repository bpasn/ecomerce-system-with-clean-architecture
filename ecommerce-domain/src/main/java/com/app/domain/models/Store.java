package com.app.domain.models;

import java.time.LocalDateTime;

public class Store extends BaseModel {
    private String storeName;

    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Store() {
    }
    
    public Store(String id,String storeName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        setId(id);
        this.storeName = storeName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Store(
            String id,
            String storeName,
            User user,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        setId(id);
        this.storeName = storeName;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Store [storeName=" + storeName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    

}
