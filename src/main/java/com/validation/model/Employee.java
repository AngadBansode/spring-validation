package com.validation.model;

import com.validation.utils.EmployeeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@DynamicUpdate
//@DynamicInsert
public class Employee extends PersonMapper{

    private Double salary;

    private String firmName;

    private String aadharNumber;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
}
