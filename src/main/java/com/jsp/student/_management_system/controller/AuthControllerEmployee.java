package com.jsp.student._management_system.controller;

import com.jsp.student._management_system.dao.EmployeeRepository;
import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.RegisterRequest;
import com.jsp.student._management_system.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/emp")
@RequiredArgsConstructor
public class AuthControllerEmployee {
    private final AuthService authService;
    @PostMapping("/register")
   public ResponseEntity<AuthResponse>register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }
}
