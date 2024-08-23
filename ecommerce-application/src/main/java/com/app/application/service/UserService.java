package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.domain.entity.UserEntity;
import com.app.infrastructure.repositories.UserJpaRepository;
import com.app.application.handler.CustomExceptionHandler;
import com.app.application.handler.EnumCode;

@Service
public class UserService {

    private final UserJpaRepository userRepository;

    UserService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getMethodName(String email) {
        if(email.isEmpty()){
            throw new CustomExceptionHandler("Email is required" , EnumCode.BAD_REQUEST);
        }
        UserEntity userEntity = userRepository.findByCustomUser(email)
                .orElseThrow(
                        () -> new CustomExceptionHandler("User with email " + email + " not found",
                                EnumCode.CONFLICT));
        return userEntity.toString();
    }

    public void createUser(UserEntity model) {

    }

}
