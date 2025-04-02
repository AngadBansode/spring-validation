package com.validation.configuration;

import com.validation.dto.Credentials;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "example")
public class PropertiesConfiguration {

    private String name;

    private String adds;

    private int age;

    private List<String> mobileNumber;

    private String gender;

    private boolean isMarried;
    private List<String> hobbies;

    private Credentials credentials;

    private Map<String, String> additionalDetails;




    @PostConstruct
    public void printAll(){

        System.out.println("Name: " + name);
        System.out.println("Adds: " + adds);
        System.out.println("Age: " + age);
        System.out.println("Mobile Number: " + mobileNumber.get(0));
        System.out.println("Hobbies: " + hobbies);
        System.out.println("Gender: " + gender);
        System.out.println("Is Married: " + isMarried);
       System.out.println("Credentials-UserName: " + credentials.getUsername());
       System.out.println("Credentials-Password: " + credentials.getPassword());
       System.out.println("Additional Details: " + additionalDetails);



    }

}
