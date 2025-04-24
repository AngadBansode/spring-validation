package com.validation.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class ProgrammaticScheduler {

    @Autowired
    private TaskScheduler taskScheduler;

    @PostConstruct
    public void scheduleTasks() {
        taskScheduler.schedule(() -> {
            System.out.println("Programmatic Task: " + System.currentTimeMillis());
        }, new CronTrigger("0 * * * * *")); // Every minute
    }
}