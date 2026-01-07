package com.jsp.student._management_system.service;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.RegisterRequestForEmployee;

public interface AuthServiceforEmployee {
    AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee);
}
