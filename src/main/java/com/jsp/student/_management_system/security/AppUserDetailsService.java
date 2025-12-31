package com.jsp.student._management_system.security;

import com.jsp.student._management_system.dao.StudentRepository;
import com.jsp.student._management_system.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Students student = studentRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Student not found"));

        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles(student.getRole()) // ADMIN / STUDENT
                .build();
    }
}
