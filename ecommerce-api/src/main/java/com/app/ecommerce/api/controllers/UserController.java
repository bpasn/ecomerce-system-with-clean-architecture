package com.app.ecommerce.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("${api.prefix.route}/users")
@Tag(name = "Users",description = "User management API")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> get(@RequestParam String email) {
        return ResponseEntity.ok(userService.getMethodName(email));
    }
    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("Users API already");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("Users API already");
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Users API already");
    }
}
