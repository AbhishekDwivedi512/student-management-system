package com.jsp.student._management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class Student {
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
    private String Password;
    private LocalDate dateOfBirth;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String role;

}
