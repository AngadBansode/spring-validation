package com.validation.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "classpath:user.yml", factory = YamlPropertySourceFactory.class)
public class UserYmlConfigurationRead {

    private String laptop;
    private String email;
    private int age;

    UserYmlConfigurationRead(){
        System.out.println("UserYmlConfigurationRead constructor");
        System.out.println(laptop + ": email: " + email + "age: " + age);
    }
}
