package com.app.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import com.app.domain.repositories.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.domain.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> , IUserRepository {

    @Query("SELECT u FROM users u WHERE u.email = :email")
    Optional<UserEntity> findByCustomUser(String email);

}
