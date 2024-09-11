package com.app.ecommerce.api.controllers;

import com.app.application.ApiResponse;
import com.app.application.dto.auth.AuthRegisReq;
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

    AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("login")
    public ResponseEntity<ApiResponse<String>>  authen(@RequestBody String body ) {
        return ResponseEntity.ok(new ApiResponse<>("Login user success"));
    }

    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Map<String,String>>> register(@RequestBody AuthRegisReq body){
        return ResponseEntity.ok(authService.register(body));
    }
    
}
