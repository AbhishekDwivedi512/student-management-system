package com.jsp.student._management_system.service.course;

import com.jsp.student._management_system.dto.courseresponse.CourseResponse;
import com.jsp.student._management_system.dto.courseresponse.RegisterForCourse;
import com.jsp.student._management_system.dto.courseresponse.UpdateCoursePrice;

public interface AuthServiceforCourse {

    CourseResponse courseregister(RegisterForCourse registerForCourse);
    CourseResponse updateCource(Integer id ,UpdateCoursePrice updateCoursePrice);

}
