package com.jsp.student._management_system.dto.courseresponse;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseResponse {
    private Integer courseId;
    private String courseName;
    private Double courseFees;

}
