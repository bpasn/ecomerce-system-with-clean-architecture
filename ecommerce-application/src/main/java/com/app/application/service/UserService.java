package com.app.application.service;

import org.springframework.stereotype.Service;

import com.app.domain.entity.UserEntity;
import com.app.domain.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getMethodName(String name, String email) {
        try {
            String response = userRepository.findCustom(name, email).toString();
            return response;
        } catch (RuntimeException e) {
            System.out.println("ERROR: MESSAGE : "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void createUser(UserEntity model) {

    }

}
