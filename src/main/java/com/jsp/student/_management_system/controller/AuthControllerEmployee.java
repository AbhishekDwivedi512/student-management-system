package com.jsp.student._management_system.controller;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.employee.LoginRequestForEmployee;
import com.jsp.student._management_system.dto.employee.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Employee;
import com.jsp.student._management_system.service.employees.AuthServiceforEmployee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/emp")
@RequiredArgsConstructor
public class AuthControllerEmployee {
    private final AuthServiceforEmployee authServiceforEmployee;
    @PostMapping("/registerEmployee")
   public ResponseEntity<AuthResponse>register(@RequestBody @Valid RegisterRequestForEmployee registerRequestForEmployee){
        return ResponseEntity.status(HttpStatus.CREATED).body(authServiceforEmployee.Employeeregister(registerRequestForEmployee));
    }
    @PostMapping("/loginEmployee")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestForEmployee loginRequestForEmployee){
        return ResponseEntity.ok(authServiceforEmployee.Employeelogin(loginRequestForEmployee));
    }
    @DeleteMapping("/delete/{employeeId}")
    public Optional<Employee> deleteById(@PathVariable int employeeId){
        return authServiceforEmployee.deleteById(employeeId);
    }

}
