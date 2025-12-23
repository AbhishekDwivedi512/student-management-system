package com.jsp.student._management_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @Column(unique = true,nullable = false)
    private String courseName;
    @Column(nullable = false)
    private double courseFees;

}
