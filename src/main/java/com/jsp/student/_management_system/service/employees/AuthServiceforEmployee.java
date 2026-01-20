package com.jsp.student._management_system.service.employees;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.LoginRequestForEmployee;
import com.jsp.student._management_system.dto.RegisterRequestForEmployee;

public interface AuthServiceforEmployee {
    AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee);
    AuthResponse Employeelogin(LoginRequestForEmployee loginRequestForEmployee);
}
