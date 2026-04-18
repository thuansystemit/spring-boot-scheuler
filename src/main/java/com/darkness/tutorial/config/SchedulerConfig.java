package com.darkness.tutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


@Configuration
@Slf4j
public class SchedulerConfig {
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);                          // Concurrent scheduled tasks
        scheduler.setThreadNamePrefix("scheduler-");
        scheduler.setAwaitTerminationSeconds(60);          // Wait up to 60s on shutdown
        scheduler.setWaitForTasksToCompleteOnShutdown(true); // Graceful shutdown
        scheduler.setErrorHandler(t ->
                // Prevent one task failure from silencing other tasks
                log.error("Scheduled task error: {}", t.getMessage(), t)
        );
        return scheduler;
    }
}
