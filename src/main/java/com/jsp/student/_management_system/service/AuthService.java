package com.jsp.student._management_system.service;


import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.RegisterRequest;

public interface AuthService  {
    AuthResponse register(RegisterRequest registerRequest);
}
