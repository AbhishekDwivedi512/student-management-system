package com.jsp.student._management_system.service.student;


import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.student.LoginRequest;
import com.jsp.student._management_system.dto.student.RegisterRequest;
import com.jsp.student._management_system.entity.Students;

import java.util.List;
import java.util.Optional;

public interface AuthService  {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
    List<Students> findAll();
    Optional<Students> deleteById(int studentId);
}
