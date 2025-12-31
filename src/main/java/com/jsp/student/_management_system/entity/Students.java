package com.jsp.student._management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated

public class Students  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id_seq")
    @SequenceGenerator(name = "student_id_seq",initialValue = 100000,allocationSize = 1)
    private int studentId;
    @Size(min =2,message = "min 2 character required")
    private String name;
    @Email
    private String email;
    @Size(min=10,max = 10,message = "value phone number")
    private String phone;
    private String password;
    private LocalDate dateOfBirth;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String role;


}
