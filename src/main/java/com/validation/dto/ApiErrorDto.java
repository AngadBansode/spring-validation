package com.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ApiErrorDto {

    private String errorMessage;
    private String status;
    private HttpStatus statusCode;
}
