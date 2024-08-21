package com.app.domain.entity;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        UserEntity user = (UserEntity) obj;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), username, password, email);
    }

    @Override
    public String toString() {
        return "UserModel [username=" + username + ", password=" + password + ", email=" + email + ", id ="
                + getId() + "]";
    }

    
}
