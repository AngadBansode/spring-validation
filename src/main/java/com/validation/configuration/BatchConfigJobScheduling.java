/*
package com.validation.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.cloud.sleuth.instrument.batch.TraceJobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfigJobScheduling {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("sampleJob")
                .start(step)
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("sampleStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Batch Task using spring batch: " + System.currentTimeMillis());
                    return RepeatStatus.CONTINUABLE;
                }).build();
    }

    @Bean
    public JobBuilderFactory jobBuilderFactory(){
        return new JobBuilderFactory();
    }
}
*/
