package com.app.application.service;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.BaseResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;
import com.app.application.dto.auth.AuthResponse;
import com.app.domain.entity.UserEntity;
import com.app.infrastructure.adapter.UserDetailsAdapter;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.exception.NotFoundException;
import com.app.infrastructure.interfaces.JwtService;

import com.app.infrastructure.services.CustomUserDetail;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.application.interfaces.AuthenService;
import com.app.domain.usecase.AuthUseCase;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenServiceImpl implements AuthenService {

    private final AuthUseCase authUseCase;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetail customUserDetail;

    public AuthenServiceImpl(AuthUseCase authUseCase, JwtService jwtService, PasswordEncoder passwordEncoder,CustomUserDetail customUserDetail) {
        this.authUseCase = authUseCase;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.customUserDetail = customUserDetail;
    }

    @Transactional
    public BaseResponse signUp(AuthRegisReq body) {
        if (authUseCase.findByEmail(body.getEmail()) != null) {
            throw new BaseException(String.format("Email '%s' already exists", body.getEmail()));
        }
        String passwordEncode = passwordEncoder.encode(body.getPassword());
        authUseCase.save(new UserEntity(body.getEmail(), body.getName(), passwordEncode));
        return new BaseResponse(HttpStatus.OK);
    }

    public AuthResponse signIn(AuthReq body) {
        UserEntity userEntity = authUseCase.findByEmail(body.getEmail());

        if (userEntity == null) {
            throw new NotFoundException("Users", body.getEmail());
        }

        if (!passwordEncoder.matches(body.getPassword(), userEntity.getPassword())) {
            throw new BaseException("Email or password incorrect!!");
        }

        UserDetails userDetails = new UserDetailsAdapter(userEntity);
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token,jwtService.generateRefreshToken(userDetails));
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        String username  = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = customUserDetail.loadUserByUsername(username);
        if(!jwtService.isTokenValid(refreshToken,userDetails)) {
            throw new BaseException("Invalid Refresh Token",HttpStatus.UNAUTHORIZED);
        }
        String newAccessToken = jwtService.generateToken(userDetails);
        return new AuthResponse(newAccessToken,refreshToken);
    }
}
