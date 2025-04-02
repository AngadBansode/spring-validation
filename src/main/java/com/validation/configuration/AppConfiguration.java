package com.validation.configuration;

import com.validation.component.Student;
import com.validation.service.impl.MesseageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

//@Configuration(proxyBeanMethods = false) - for singleton bean by default proxy method is used.
// https://www.youtube.com/watch?v=VoK6-OiSPu4 -- proxy
@Slf4j
@Configuration
public class AppConfiguration {
    List<String> bootstrapServers= new ArrayList<>();

     @Autowired
     private Student student;
    @Bean
    @Profile("dev")
    @Primary
//    @ConditionalOnProperty(prefix = "app.active",name ="env",havingValue = "dev")
    public KafkaProperties devKafkaProperties() {

        KafkaProperties properties = new KafkaProperties();
        bootstrapServers.add("10.10.10.10");
        properties.setBootstrapServers(bootstrapServers);
        properties.setClientId("Kafka Dev Client ID");
        log.info("Dev kafka bean initializing...");
        return properties;
    }

    @Bean("prodKafkaProperties")
    @Profile("prod")
//    @Primary
//    @ConditionalOnProperty(prefix = "app.active",name ="env",havingValue = "prod")
    public KafkaProperties prodKafkaProperties() {

        KafkaProperties properties = new KafkaProperties();
        bootstrapServers.add("201.20.20.20");
        properties.setBootstrapServers(bootstrapServers);
        properties.setClientId("Kafka Prod Client ID");
        log.info("PROD kafka bean initializing...");
        return properties;
    }

    /*@Bean("stgKafkaProperties")
    @Profile("stg")
    @Primary
//    @ConditionalOnProperty(prefix = "app.active",name ="env",havingValue = "stg")
    public KafkaProperties stgKafkaProperties() {

        KafkaProperties properties = new KafkaProperties();
        bootstrapServers.add("30.30.30.30");
        properties.setBootstrapServers(bootstrapServers);
        properties.setClientId("Kafka STG Client ID");

        log.info("STG kafka bean initializing...");
        return properties;
    }*/

    @Bean
    @Conditional(MySimpleCondition.class)
//    @Lazy
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MesseageService messeageService(){
        return  new MesseageService();
    }

    @Bean
    public String test(){
        System.out.println("age: " + student.getAge());
        System.out.println("name: " + student.getName());

        return "name";

    }
}
