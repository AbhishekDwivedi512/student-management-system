package com.jsp.student._management_system.dto.courseresponse;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class RegisterForCourse {

    @NotEmpty
    @Size(min=4,max=4,message = "The id is mandatory of 4 digit")
    private int courseId;
    @NotEmpty
    private String courseName;
    @NotEmpty
    private double courseFees;
}
