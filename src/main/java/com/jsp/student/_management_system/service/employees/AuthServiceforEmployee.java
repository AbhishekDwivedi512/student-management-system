package com.jsp.student._management_system.service.employees;

import com.jsp.student._management_system.dto.AuthResponse;
import com.jsp.student._management_system.dto.employee.LoginRequestForEmployee;
import com.jsp.student._management_system.dto.employee.RegisterRequestForEmployee;
import com.jsp.student._management_system.entity.Employee;

import java.util.Optional;

public interface AuthServiceforEmployee {
    AuthResponse Employeeregister(RegisterRequestForEmployee registerRequestForEmployee);
    AuthResponse Employeelogin(LoginRequestForEmployee loginRequestForEmployee);
    Optional <Employee> deleteById(int employeeId);
}
