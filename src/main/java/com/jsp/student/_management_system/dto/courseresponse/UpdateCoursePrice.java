package com.jsp.student._management_system.dto.courseresponse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class UpdateCoursePrice {

    @NotNull(message = "Course price is required")
    @Positive(message = "Course price must be positive")
    private Double coursePrice;

}
