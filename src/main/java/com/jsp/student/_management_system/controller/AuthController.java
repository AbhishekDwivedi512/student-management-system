package com.jsp.student._management_system.controller;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.LoginRequest;
import com.jsp.student._management_system.dto.RegisterRequest;
import com.jsp.student._management_system.entity.Students;
import com.jsp.student._management_system.service.student.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }


    @GetMapping("/All")
    public List<Students> findAll() {
        return authService.findAll();
    }

}
