package com.validation.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@IdClass(ProfileIndustryCompositeID.class)
@Table(name = "person_detail", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"personId", "departmentId"})
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_id")
    private String personId;

    private String name;

    private Integer age;

    @Column(name = "department_id")
    private String departmentId;

    // other fields, getters, and setters
}