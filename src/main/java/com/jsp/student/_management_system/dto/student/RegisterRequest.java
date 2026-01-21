package com.jsp.student._management_system.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @Size(min=10,max = 10,message = "mobile number should be 10 digit only")
    private String phone;
    private String password;
    private String role;

    private LocalDate dateOfBirth;
}
