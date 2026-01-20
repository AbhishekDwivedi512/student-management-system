package com.jsp.student._management_system.dto;

import lombok.Data;

@Data
public class LoginRequestForEmployee {
    private String email;
    private String password;
}
