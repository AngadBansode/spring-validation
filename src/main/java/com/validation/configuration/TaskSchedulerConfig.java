package com.validation.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableScheduling
public class TaskSchedulerConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }
}
