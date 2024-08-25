package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.domain.entity.UserEntity;
import com.app.domain.exceptions.CustomExceptionHandler;
import com.app.domain.exceptions.EnumCode;
import com.app.infrastructure.repositories.UserJpaRepository;

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
