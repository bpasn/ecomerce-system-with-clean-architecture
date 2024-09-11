package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.UserEntity;
public interface IAuthRepository {
        Optional<UserEntity> findByEmail(String email);
}
