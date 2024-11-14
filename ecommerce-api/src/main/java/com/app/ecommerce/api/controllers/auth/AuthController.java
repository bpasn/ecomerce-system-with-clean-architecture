package com.app.ecommerce.api.controllers.auth;

import com.app.application.dto.BaseResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;

import com.app.application.dto.auth.AuthResponse;
import com.app.application.dto.auth.ProviderRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.application.interfaces.AuthenService;


@RestController
@RequestMapping("${api.prefix.route}/auth")
public class AuthController {
    private final AuthenService authenService;

    AuthController(AuthenService authenService) {
        this.authenService = authenService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> authen(@RequestBody AuthReq body) {
        return ResponseEntity.ok(authenService.signIn(body));
    }


    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> register(@RequestBody AuthRegisReq body) {
        return ResponseEntity.ok(authenService.signUp(body));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody  RefreshToken refreshToken){
        System.out.println("REFRESH TOKEN");
        return ResponseEntity.ok(authenService.refreshToken(refreshToken.refreshToken));
    }

    @PostMapping("/provider")
    public ResponseEntity<AuthResponse> provider(@RequestBody ProviderRequest provider){
        return ResponseEntity.ok(authenService.provider(provider));
    }


    record RefreshToken(String refreshToken){}

}
