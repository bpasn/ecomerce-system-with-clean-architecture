package com.app.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, String>{
        Optional<UserEntity> findByEmail(String email);

}
