package com.app.application.interfaces;

import com.app.application.ApiResponse;
import com.app.application.dto.auth.AuthRegisReq;
import java.util.Map;

public interface AuthService {
    ApiResponse<Map<String,String>> register(AuthRegisReq body);
}
