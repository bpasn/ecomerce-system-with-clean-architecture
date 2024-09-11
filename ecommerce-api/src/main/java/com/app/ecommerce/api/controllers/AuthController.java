package com.app.ecommerce.api.controllers;

import com.app.application.ApiResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.interfaces.AuthService;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@RestController
@RequestMapping("${api.prefix.route}/auth")
public class AuthController {
    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<ApiResponse<Map<String, String>>> authen(@RequestBody AuthReq body) {
        ;
        return ResponseEntity.ok(authService.signin(body));
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Map<String, String>>> register(@RequestBody AuthRegisReq body) {
        return ResponseEntity.ok(authService.register(body));
    }

}
