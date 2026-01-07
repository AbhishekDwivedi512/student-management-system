package com.jsp.student._management_system.service;


import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.LoginRequest;
import com.jsp.student._management_system.dto.RegisterRequest;
import com.jsp.student._management_system.dto.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Students;

import java.util.List;

public interface AuthService  {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
    List<Students> findAll();

}
