package com.jsp.student._management_system.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class RegisterRequestForEmployee {

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


