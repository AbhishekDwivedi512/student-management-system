package com.jsp.student._management_system.service;

import com.jsp.student._management_system.dao.EmployeeRepository;
import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Employee;
import com.jsp.student._management_system.exception.EmployeeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthserviceimplforEmployee implements AuthServiceforEmployee{

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(registerRequestForEmployee.getEmail());
        if(existingEmployee.isPresent()){
            throw new EmployeeException("Employee is not found");
        }
        Employee employee =Employee.builder()
                .name(registerRequestForEmployee.getName())
                .email(registerRequestForEmployee.getEmail())
                .phone(registerRequestForEmployee.getPhone())
                .role(registerRequestForEmployee.getRole())
                .Password(registerRequestForEmployee.getPassword())
                .dateOfBirth(registerRequestForEmployee.getDateOfBirth())
                .build();

        Employee saveEmployees = employeeRepository.save(employee);

        return AuthResponse.builder()
                .name(saveEmployees.getName())
                .email(saveEmployees.getEmail())
                .build();
    }
}
