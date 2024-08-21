package com.app.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
