package com.app.application.interfaces;

import com.app.application.ApiResponse;
import com.app.application.dto.auth.AuthRegisReq;
import com.app.application.dto.auth.AuthReq;

import java.util.Map;

public interface AuthService {
    ApiResponse<Map<String,String>> register(AuthRegisReq body);
    ApiResponse<Map<String,String>> signin(AuthReq body);
}
