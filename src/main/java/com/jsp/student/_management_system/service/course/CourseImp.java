package com.jsp.student._management_system.service.course;

import com.jsp.student._management_system.dao.CourseRepository;

import com.jsp.student._management_system.dto.courseresponse.CourseResponse;
import com.jsp.student._management_system.dto.courseresponse.RegisterForCourse;
import com.jsp.student._management_system.entity.Course;
import com.jsp.student._management_system.exception.CourseException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Builder
@RequiredArgsConstructor
public class CourseImp implements AuthServiceforCourse{

    private final CourseRepository courseRepository;


    @Override
    public CourseResponse courseregister(RegisterForCourse registerForCourse) {
        Optional<Course> existingCourse =courseRepository.findById(registerForCourse.getCourseId());

        if(existingCourse.isPresent()){
            throw new CourseException("The Course is AllReady present");
        }
        Course course= Course.builder()
                .courseId(registerForCourse.getCourseId())
                .courseName(registerForCourse.getCourseName())
                .courseFees(registerForCourse.getCourseFees())
                .build();

        Course saveCourse =courseRepository.save(course);


        return CourseResponse.builder()
                .courseName(saveCourse.getCourseName())
                .courseFees(saveCourse.getCourseFees())
                .build();
    }
}
