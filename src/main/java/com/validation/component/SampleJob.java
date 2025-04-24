package com.validation.component;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SampleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Quartz Task: " + System.currentTimeMillis());
    }
}
