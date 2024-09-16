package com.app.infrastructure.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.interfaces.JwtAuthenticationFilter;
import com.app.infrastructure.interfaces.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtAuthenticationFilterImpl extends OncePerRequestFilter implements JwtAuthenticationFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    public JwtAuthenticationFilterImpl(
            JwtService jwtService,
            UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (isTokenMissingOrInValid(authHeader)) {
            filterChain.doFilter(request, response);
            log.info(String.format("ERROR IS : %s", authHeader));
            return;
        }
        try {
            final String jwt = extractJwtToken(authHeader);
            System.out.println("JWT : "+jwt+"");
            if (jwt == null || jwt.equals("null")) {
                handleInvalidToken(request, response);
                return;
            }

            String userEmail = jwtService.extractUsername(jwt);
            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                handleValidToken(userEmail, jwt, request);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            resolver.resolveException(request, response, null, new BaseException(e.getMessage(),HttpStatus.UNAUTHORIZED));
        }
    }

    @Override
    public boolean isTokenMissingOrInValid(String authHeader) {
        return authHeader == null || !authHeader.startsWith("Bearer ");
    }

    @Override
    public String extractJwtToken(String authHeader) {
        return authHeader.substring(7);
    }

    @Override
    public void handleInvalidToken(HttpServletRequest request, HttpServletResponse response) {
        resolver.resolveException(request, response, null, new BaseException("Token invalid",HttpStatus.UNAUTHORIZED));
    }

    @Override
    public void handleValidToken(String userEmail, String jwt, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        System.out.println(String.format("USER DETAILS : "));
        if (jwtService.isTokenValid(jwt, userDetails)) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request, null,
                    userDetails.getAuthorities());
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }

}
