package com.jsp.student._management_system.dto.courseresponse;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseResponse {

    private String courseName;
    private double courseFees;

}
