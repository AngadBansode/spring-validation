package com.validation.configuration;

import com.validation.service.UniqueBeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SameClassNameConfig {

    @Bean
    public com.validation.component.UniqueBeanTest uniqueBeanTest1(){
        return new com.validation.component.UniqueBeanTest();
    }
    @Bean
    public com.validation.service.UniqueBeanTest uniqueBeanTest2(){
        return new com.validation.service.UniqueBeanTest();
    }

}
