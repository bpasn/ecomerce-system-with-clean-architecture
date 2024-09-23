package com.app.infrastructure.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "users")
public class UserEntity extends BaseEntity implements UserDetails {

    private String email;
    private String name;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreEntity> stores = new ArrayList<>();

    public UserEntity(){}

    public UserEntity(String email, String name, String password){
        setEmail(email);
        setName(name);
        setPassword(password);
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

    public List<StoreEntity> getStores() {
        return stores;
    }

    public void setStores(List<StoreEntity> stores) {
        this.stores = stores;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }
}
