package com.app.infrastructure.services;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import com.app.domain.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String extractUsername(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(UserEntity userDetails);
    String generateToken(Map<String,Object> extractClaims,UserEntity userDetails);
    boolean isTokenValid(String token , UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extraExpired(String token);
    Claims extractAllClaims(String token);
    SecretKey getSignInKey();
}
