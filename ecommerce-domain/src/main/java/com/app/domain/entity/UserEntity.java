package com.app.domain.entity;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {
    private String email;
    private String password;



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
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),  password, email);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id= '"+getId()+"'," +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
