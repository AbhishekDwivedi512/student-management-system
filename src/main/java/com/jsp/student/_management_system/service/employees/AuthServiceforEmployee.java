package com.jsp.student._management_system.service.employees;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.employee.LoginRequestForEmployee;
import com.jsp.student._management_system.dto.employee.RegisterRequestForEmployee;

public interface AuthServiceforEmployee {
    AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee);
    AuthResponse Employeelogin(LoginRequestForEmployee loginRequestForEmployee);

}
