package com.jsp.student._management_system.dto.student;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
