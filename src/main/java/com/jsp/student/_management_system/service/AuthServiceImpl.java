package com.jsp.student._management_system.service;

import com.jsp.student._management_system.dao.EmployeeRepository;
import com.jsp.student._management_system.dao.StudentRepository;
import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.RegisterRequest;
import com.jsp.student._management_system.entity.Students;
import com.jsp.student._management_system.exception.StudentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public AuthResponse register(RegisterRequest registerRequest){
        Optional<Students> existingStudent =
                studentRepository.findByEmail(registerRequest.getEmail());

        if (existingStudent.isPresent()) {
            throw new StudentException("Student already exists with this email");
        }
        Students students =Students.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .password(registerRequest.getPassword())
                .dateOfBirth(registerRequest.getDateOfBirth())
                .build();
        Students savedStudent =studentRepository.save(students);

        AuthResponse authResponse=AuthResponse.builder()
                .name(savedStudent.getName())
                .email(savedStudent.getEmail())
                .build();

        return authResponse;
    }
}
