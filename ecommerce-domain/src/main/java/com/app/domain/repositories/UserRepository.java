package com.app.domain.repositories;


import com.app.domain.entity.UserEntity;

public interface UserRepository {
    UserEntity findCustom(String username,String email);
}
