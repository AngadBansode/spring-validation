package com.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    String firstName;
    String lastName;
    int age;
    String adds;
    String firmName;
    Double salary;
}
