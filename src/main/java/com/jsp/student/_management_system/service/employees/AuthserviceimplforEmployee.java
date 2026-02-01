package com.jsp.student._management_system.service.employees;

import com.jsp.student._management_system.dao.EmployeeRepository;
import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.employee.LoginRequestForEmployee;
import com.jsp.student._management_system.dto.employee.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Employee;
import com.jsp.student._management_system.exception.EmployeeException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Builder
@RequiredArgsConstructor
public class AuthserviceimplforEmployee implements AuthServiceforEmployee {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee) {
        Optional<Employee> existingEmployee =
                employeeRepository.findByEmail(registerRequestForEmployee.getEmail());
        if(existingEmployee.isPresent()){
            throw new EmployeeException("Employee is allReady with this Email ");
        }
        Employee employee =Employee.builder()
                .name(registerRequestForEmployee.getName())
                .email(registerRequestForEmployee.getEmail())
                .phone(registerRequestForEmployee.getPhone())
                .role(registerRequestForEmployee.getRole())
                .Password(passwordEncoder.encode(registerRequestForEmployee.getPassword()))
                .dateOfBirth(registerRequestForEmployee.getDateOfBirth())
                .build();

        Employee saveEmployees = employeeRepository.save(employee);

        return AuthResponse.builder()
                .name(saveEmployees.getName())
                .email(saveEmployees.getEmail())
                .build();
    }

    @Override
    public AuthResponse Employeelogin(LoginRequestForEmployee loginRequestForEmployee) {
        Employee employee=employeeRepository.findByEmail(loginRequestForEmployee.getEmail())
                .orElseThrow(() -> new EmployeeException("Invalid email or password"));

        if(!passwordEncoder.matches(
                loginRequestForEmployee.getPassword(),
                employee.getPassword())){
           throw new EmployeeException("Invalid email or password");
        }

        return AuthResponse.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }

    @Override
    public Optional<Employee> deleteById(int employeeId) {
        if(!employeeRepository.existsById(employeeId))
            throw new EmployeeException("employee is not found with id"+employeeId+"please check the id");
        return employeeRepository.deleteById(employeeId);
    }

}
