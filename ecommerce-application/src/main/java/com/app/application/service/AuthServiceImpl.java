package com.app.application.service;

import com.app.application.ApiResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;
import com.app.domain.entity.UserEntity;
import com.app.infrastructure.adapter.UserDetailsAdapter;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;
import com.app.infrastructure.interfaces.JwtService;

import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.application.interfaces.AuthService;
import com.app.domain.usecase.AuthUseCase;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthUseCase authUseCase;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthUseCase authUseCase, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authUseCase = authUseCase;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public ApiResponse<Map<String, String>> register(AuthRegisReq body) {
        if (authUseCase.findByEmail(body.getEmail()) != null) {
            throw new BaseException(String.format("Email '%s' already exists", body.getEmail()));
        }
        String passwordEncode = passwordEncoder.encode(body.getPassword());
        UserEntity userEntity = authUseCase.insert(new UserEntity(body.getEmail(), body.getName(), passwordEncode));
        UserDetails userDetails = new UserDetailsAdapter(userEntity);
        String token = jwtService.generateToken(userDetails);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return new ApiResponse<>(map);
    }

    @Override
    public ApiResponse<Map<String, String>> signin(AuthReq body) {
        Map<String, String> map = new HashMap<>();
        UserEntity userEntity = authUseCase.findByEmail(body.getEmail());

        if (userEntity == null) {
            throw new NotFoundException("Users", body.getEmail());
        }

        if (!passwordEncoder.matches(body.getPassword(), userEntity.getPassword())) {
            throw new BaseException("Email or password incorrect!!");
        }

        UserDetails userDetails = new UserDetailsAdapter(userEntity);
        String token = jwtService.generateToken(userDetails);
        map.put("token", token);

        return new ApiResponse<>(map);
    }
}
