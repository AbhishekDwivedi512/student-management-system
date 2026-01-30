package com.jsp.student._management_system.controller;

import com.jsp.student._management_system.dto.courseresponse.CourseResponse;
import com.jsp.student._management_system.dto.courseresponse.RegisterForCourse;
import com.jsp.student._management_system.dto.courseresponse.UpdateCoursePrice;
import com.jsp.student._management_system.service.course.AuthServiceforCourse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/course")
@RequiredArgsConstructor
public class AuthControllerCourse {

    private final AuthServiceforCourse authServiceforCourse;

    @PostMapping("/register")
    public ResponseEntity<CourseResponse> register(@RequestBody @Valid RegisterForCourse registerForCourse){

        return ResponseEntity.status(HttpStatus.CREATED).body(authServiceforCourse.courseregister(registerForCourse));
    }
    @PutMapping("/{id}/priceupdate")
    public ResponseEntity<CourseResponse> UpdatePrice(@PathVariable Integer id, @Valid @RequestBody UpdateCoursePrice updateCoursePrice){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authServiceforCourse.updateCource(id, updateCoursePrice));
    }

}
