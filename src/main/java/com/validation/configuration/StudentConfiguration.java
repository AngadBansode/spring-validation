package com.validation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class StudentConfiguration {

  @Bean
  @Primary
   public String getName(){
      return "Angad";
  }
    @Bean
    public int age(){
        return 28;
    }

}
