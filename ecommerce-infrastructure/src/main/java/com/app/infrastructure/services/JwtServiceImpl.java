package com.app.infrastructure.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import com.app.domain.usecase.AuthUseCase;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.interfaces.JwtService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.private-key}")
    private String SECRET_KEY;

    @Value("${jwt.expired}")
    private int expired;
    @Value("${jwt.refreshTokenExpire}")
    private int refreshTokenExpire;

    private final AuthUseCase authUseCase;
    
    
    public JwtServiceImpl(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateToken(String username) {
        HashMap<String,String> map = new HashMap<>();
        map.put("userId", authUseCase.findByEmail(username).getId());
        return generateToken(map, username, expired);
    }

    @Override
    public String generateRefreshToken(String username){
        return generateToken(new HashMap<>(),username,refreshTokenExpire);
    }
    @Override
    public String generateToken(Map<String, ?> extractClaims, String username,long expirationTime) {
       try {
           return Jwts.builder()
                   .claims(extractClaims)
                   .subject(username)
                   .issuedAt(new Date(System.currentTimeMillis()))
                   .expiration(new Date(System.currentTimeMillis() + expirationTime))
                   .signWith(getSignInKey())
                   .compact();
       }catch (Exception ex){
           throw new BaseException(ex.getMessage());
       }
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extraExpired(token).before(new Date());
    }

    @Override
    public Date extraExpired(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
    }

    @Override
    public SecretKey getSignInKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

}
