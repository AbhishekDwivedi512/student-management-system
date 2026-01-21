package com.jsp.student._management_system.dto.employee;

import lombok.Data;

@Data
public class LoginRequestForEmployee {
    private String email;
    private String password;
}
