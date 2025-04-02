package com.validation.repository;

import com.validation.model.Employee;
import com.validation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
