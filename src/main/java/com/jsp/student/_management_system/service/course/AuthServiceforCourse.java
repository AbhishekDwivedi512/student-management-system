package com.jsp.student._management_system.service.course;

import com.jsp.student._management_system.dto.courseresponse.CourseResponse;
import com.jsp.student._management_system.dto.courseresponse.RegisterForCourse;

public interface AuthServiceforCourse {

    CourseResponse courseregister(RegisterForCourse registerForCourse);

}
