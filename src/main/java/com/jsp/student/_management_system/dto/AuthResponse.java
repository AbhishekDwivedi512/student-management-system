package com.jsp.student._management_system.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthResponse {

    private String name;
    private String email;


}
