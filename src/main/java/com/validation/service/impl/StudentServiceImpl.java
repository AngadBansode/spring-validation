package com.validation.service.impl;

import com.validation.model.Student;
import com.validation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public String saveStudent(Student student){
          studentRepository.save(student);
          int no = 2/0;
          return "student saved....";
    }

}
