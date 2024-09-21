package com.app.domain.repositories;

import java.util.Optional;

import com.app.domain.models.User;
public interface IAuthRepository {
        Optional<User> findByEmail(String email);
}
