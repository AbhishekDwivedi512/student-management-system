package com.jsp.student._management_system.service;

import com.jsp.student._management_system.dao.EmployeeRepository;
import com.jsp.student._management_system.dao.StudentRepository;
import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.LoginRequest;
import com.jsp.student._management_system.dto.RegisterRequest;
import com.jsp.student._management_system.dto.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Employee;
import com.jsp.student._management_system.entity.Students;
import com.jsp.student._management_system.exception.EmployeeException;
import com.jsp.student._management_system.exception.StudentException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

        Optional<Students> existingStudent =
                studentRepository.findByEmail(registerRequest.getEmail());

        if (existingStudent.isPresent()) {
            throw new StudentException("Student already exists with this email");
        }

        Students students = Students.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .dateOfBirth(registerRequest.getDateOfBirth())
                .build();

        Students savedStudent = studentRepository.save(students);

        return AuthResponse.builder()
                .name(savedStudent.getName())
                .email(savedStudent.getEmail())
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Students student = studentRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new StudentException("Invalid email or password"));

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                student.getPassword())) {
            throw new StudentException("Invalid email or password");
        }

        return AuthResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }


}
