package com.app.infrastructure.interfaces;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface JwtAuthenticationFilter extends Filter {
    boolean isTokenMissingOrInValid(String authHeader);

    String extractJwtToken(String authHeader);

    void handleInvalidToken(HttpServletRequest request, HttpServletResponse response);

    void handleValidToken(String userEmail, String jwt, HttpServletRequest request);
}
