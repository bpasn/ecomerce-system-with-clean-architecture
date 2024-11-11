package com.app.application.service;

import com.app.application.dto.auth.ProviderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.application.dto.BaseResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;
import com.app.application.dto.auth.AuthResponse;
import com.app.application.interfaces.AuthenService;
import com.app.domain.models.User;
import com.app.domain.usecase.AuthUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.interfaces.JwtService;

import jakarta.transaction.Transactional;

@Service
public class AuthenServiceImpl implements AuthenService {

    private final AuthUseCase authUseCase;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public AuthenServiceImpl(AuthUseCase authUseCase, JwtService jwtService, PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) {
        this.authUseCase = authUseCase;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Transactional
    public BaseResponse signUp(AuthRegisReq body) {
        if (authUseCase.findByEmail(body.getEmail()) != null) {
            throw new BaseException(String.format("Email '%s' already exists", body.getEmail()));
        }
        String passwordEncode = passwordEncoder.encode(body.getPassword());
        authUseCase.save(new User(body.getEmail(), body.getName(), passwordEncode));
        return new BaseResponse(HttpStatus.OK);
    }

    public AuthResponse signIn(AuthReq body) {
        User user = authUseCase.findByEmail(body.getEmail());
        if (user == null) {
            String  message = String.format("Email not found with email : %s",body.getEmail());
            throw new BaseException(message, HttpStatus.BAD_REQUEST);
        }
        if (!passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            throw new BaseException("Email or password incorrect!!");
        }
       return generateAuthResponse(user.getEmail());
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        String username = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!jwtService.isTokenValid(refreshToken, userDetails)) {
            throw new BaseException("Invalid Refresh Token", HttpStatus.UNAUTHORIZED);
        }
        String newAccessToken = jwtService.generateToken(userDetails.getUsername());
        return new AuthResponse(newAccessToken, refreshToken);
    }


    @Override
    public Boolean findByProviderAndProviderId(String provider, String providerId) {
        return authUseCase.findByProviderAndProviderId(provider,providerId) != null;
    }

    @Override
    public AuthResponse signUpProvider(ProviderRequest provider) {
        User userModel = new User();
        userModel.setProvider(provider.getProvider());
        userModel.setProviderId(provider.getProviderId());
        userModel.setName(provider.getName());
        userModel.setEmail(provider.getEmail());

        User userSave = authUseCase.save(userModel);
        return generateAuthResponse(userSave.getEmail());
    }

    @Override
    public AuthResponse signInProvider(ProviderRequest provider) {
        User user = authUseCase.findByProviderAndProviderId(provider.getProvider(), provider.getProviderId());
        System.out.println("USER IS : " + user);
        if(user == null){
            return signUpProvider(provider);
        }
        return generateAuthResponse(user.getEmail());
    }

    private AuthResponse generateAuthResponse(String email) {
        String token = jwtService.generateToken(email);
        String refreshToken = jwtService.generateRefreshToken(email);
        return new AuthResponse(token, refreshToken);
    }
}
