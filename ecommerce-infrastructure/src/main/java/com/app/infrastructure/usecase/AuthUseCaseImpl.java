package com.app.infrastructure.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.domain.models.User;
import com.app.domain.usecase.AuthUseCase;
import com.app.infrastructure.entity.UserEntity;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;
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
        User user = UserMapperInfra.INSTANCE.toModel(userJpaRepository.findByEmail(email).orElse(null));
        System.out.println("USER : "+user.toString());
        return userJpaRepository.findByEmail(email).map(userMapper::toModel).orElse(null);
    }

}
