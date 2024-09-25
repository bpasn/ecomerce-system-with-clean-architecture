package com.app.domain.models;

import java.time.LocalDateTime;

public class User extends BaseModel {

    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    public User(){}

    public User(String email,String name, String password){
        setEmail(email);
        setName(name);
        setPassword(password);
    }
    public User(String id,String email,String name, String password){
        setId(id);
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", name=" + name + ", password=" + password + "]";
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
