package com.jsp.student._management_system.service.course;

import com.jsp.student._management_system.dao.CourseRepository;

import com.jsp.student._management_system.dto.courseresponse.CourseResponse;
import com.jsp.student._management_system.dto.courseresponse.RegisterForCourse;
import com.jsp.student._management_system.dto.courseresponse.UpdateCoursePrice;
import com.jsp.student._management_system.entity.Course;
import com.jsp.student._management_system.exception.CourseException;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Builder
@RequiredArgsConstructor
public class CourseImp implements AuthServiceforCourse{

    private final CourseRepository courseRepository;
   // private Object updateCoursePrice;


    @Override

    public CourseResponse courseregister(RegisterForCourse registerForCourse) {
        if (courseRepository.existsByCourseName(registerForCourse.getCourseName())) {
            throw new CourseException("Course already exists with name: "
                    + registerForCourse.getCourseName());
        }
        Course course= Course.builder()
                .courseName(registerForCourse.getCourseName())
                .courseFees(registerForCourse.getCourseFees())
                .build();

        Course saveCourse =courseRepository.save(course);


        return CourseResponse.builder()
                .courseId(saveCourse.getCourseId())
                .courseName(saveCourse.getCourseName())
                .courseFees(saveCourse.getCourseFees())
                .build();
    }

    @Override
    @Transactional
    public CourseResponse updateCource(Integer id,UpdateCoursePrice updateCoursePrice) {

        Course course =courseRepository.findById(id)
                .orElseThrow(()->new CourseException("The cource is not found"+id));

        course.setCourseFees(updateCoursePrice.getCoursePrice());

        Course saveprice =courseRepository.save(course);

        return CourseResponse.builder()
                .courseId(saveprice.getCourseId())
                .courseName(saveprice.getCourseName())
                .courseFees(saveprice.getCourseFees())
                .build();
    }
}
