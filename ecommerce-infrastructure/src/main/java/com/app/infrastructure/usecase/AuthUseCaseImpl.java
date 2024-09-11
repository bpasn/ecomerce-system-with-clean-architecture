package com.app.infrastructure.usecase;

import com.app.infrastructure.repositories.UserJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.app.domain.entity.UserEntity;
import com.app.domain.usecase.AuthUseCase;

@Service
public class AuthUseCaseImpl extends BaseUseCaseImpl<UserEntity> implements AuthUseCase {

    private final UserJpaRepository userJpaRepository;
    public AuthUseCaseImpl(UserJpaRepository userJpaRepository) {
        super(userJpaRepository);
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userJpaRepository.findByEmail(email).orElse(null);
    }
}
