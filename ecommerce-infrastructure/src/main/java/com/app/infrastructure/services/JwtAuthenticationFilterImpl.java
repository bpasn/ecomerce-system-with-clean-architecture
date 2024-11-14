package com.app.infrastructure.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.app.infrastructure.config.SecurityConfig;
import com.app.infrastructure.exception.BaseException;
import com.app.infrastructure.interfaces.JwtAuthenticationFilter;
import com.app.infrastructure.interfaces.JwtService;
import com.app.infrastructure.repositories.UserJpaRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilterImpl extends OncePerRequestFilter implements JwtAuthenticationFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final UserJpaRepository userJpaRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Value("${api.security.x-api-key}")
    private String xApiSecurity;

    public JwtAuthenticationFilterImpl(
            JwtService jwtService,
            UserDetailsService userDetailsService,
            UserJpaRepository userJpaRepository
            ) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        String uri = request.getRequestURI();

        
       if(uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")){
        System.out.println(uri);
           filterChain.doFilter(request, response);
           return;
       }
        String xApi = request.getHeader("x-api-key");
        if(!xApiSecurity.equals(xApi)){
            response.sendError(HttpStatus.FORBIDDEN.value(),"Access Denied: Invalid or Missing Header");
            return;
        }
        AntPathMatcher pathMatcher = new AntPathMatcher();
        for (String publicPath : SecurityConfig.publicRouter) {
            if (pathMatcher.match(publicPath, uri)) {
                filterChain.doFilter(request, response); // ข้ามการตรวจสอบ security
                return;
            }
        }
//        AntPathMatcher pathMatcher = new AntPathMatcher();
//        for (String publicPath : SecurityConfig.publicRouter) {
//            if (pathMatcher.match(publicPath, uri) && !uri.startsWith("/api/v1/admin")) {
//                if(uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")){
//                    filterChain.doFilter(request, response);
//                    return;
//                }
//                String xApi = request.getHeader("x-api-key");
//                if(!xApiSecurity.equals(xApi)){
//                    resolver.resolveException(request, response, null,
//                            new BaseException("Unauthorized", HttpStatus.UNAUTHORIZED));
//                    return;
//                }
//                filterChain.doFilter(request, response);
//                return;
//            }
//        }

        final String authHeader = request.getHeader("Authorization");

        if (isTokenMissingOrInValid(authHeader)) {
            filterChain.doFilter(request, response);
            System.out.printf("ERROR IS : %s%n", authHeader);
            return;
        }
        try {
            final String jwt = extractJwtToken(authHeader);
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
            resolver.resolveException(request, response, null,
                    new BaseException(e.getMessage(), HttpStatus.UNAUTHORIZED));
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
        resolver.resolveException(request, response, null, new BaseException("Token invalid", HttpStatus.UNAUTHORIZED));
    }

    @Override
    public void handleValidToken(String userEmail, String jwt, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(jwt, userDetails)) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }

}
