package com.app.infrastructure.repositories;


import com.app.domain.repositories.IAuthRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, String>, IAuthRepository {



}
