package com.app.infrastructure.usecase;

import org.springframework.stereotype.Service;

import com.app.domain.models.User;
import com.app.domain.usecase.AuthUseCase;
import com.app.infrastructure.entity.UserEntity;
import com.app.infrastructure.mapper.UserMapperInfra;
import com.app.infrastructure.repositories.UserJpaRepository;

@Service
public class AuthUseCaseImpl extends BaseUseCaseImpl<UserEntity, User> implements AuthUseCase {

    private final UserJpaRepository userJpaRepository;
    private final UserMapperInfra userMapper;

    public AuthUseCaseImpl(UserJpaRepository userJpaRepository, UserMapperInfra userMapper) {
        super(userJpaRepository, userMapper);
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(userMapper::toModel).orElse(null);
    }

}
