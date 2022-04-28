package com.hjk.shopboot.batch;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JobScheduler {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedRate = 300000 * 1000L,initialDelay = 100000 * 1000L)
    public void executeJob(){
        try{
            jobLauncher.run(job,
                            new JobParametersBuilder().addString("datetime",LocalDateTime.now().toString())
                            .toJobParameters());
        }
        catch(JobExecutionException ex){
            ex.printStackTrace();
        }
    }

}
