package com.jsp.student._management_system.dao;

import com.jsp.student._management_system.entity.Course;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    boolean existsByCourseName(@NotBlank String courseName);
}
