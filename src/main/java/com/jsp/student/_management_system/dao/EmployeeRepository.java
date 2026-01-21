package com.jsp.student._management_system.dao;

import com.jsp.student._management_system.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     Optional<Employee> findByEmail( String email);

}
