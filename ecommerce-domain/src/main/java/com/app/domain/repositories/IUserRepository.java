package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.entity.UserEntity;

public interface IUserRepository {
        Optional<UserEntity> findByCustomUser(String email);

}
