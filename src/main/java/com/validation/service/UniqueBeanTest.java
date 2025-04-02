package com.validation.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
// same bean created in service pack
//@Component
//@Primary
public class UniqueBeanTest {

    public UniqueBeanTest(){
        System.out.println("From service class..");
    }
}
