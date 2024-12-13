package com.configuration;

import com.batch.CustomProcessor;
import com.batch.CustomReader;
import com.batch.CustomWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableAutoConfiguration
public class JobConfiguration {

    @Bean
    Job createJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("job", jobRepository)
                .flow(createStep(jobRepository,transactionManager)).end().build();
    }

    @Bean
    Step createStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<String, String> chunk(3,transactionManager)
                .allowStartIfComplete(true)
                .reader(new CustomReader())
                .processor(new CustomProcessor())
                .writer(new CustomWriter())
                .build();
    }
}