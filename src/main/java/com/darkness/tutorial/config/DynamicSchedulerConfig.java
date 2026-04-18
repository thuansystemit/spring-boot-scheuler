package com.darkness.tutorial.config;

import com.darkness.tutorial.models.ScheduleConfig;
import com.darkness.tutorial.repository.ScheduleConfigRepository;
import com.darkness.tutorial.services.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DynamicSchedulerConfig implements SchedulingConfigurer {

    private final ReportService reportService;
    private final ScheduleConfigRepository configRepository;

    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {

        // Dynamic cron — reads expression from database at each trigger evaluation
        registrar.addTriggerTask(
                // Task to run
                () -> {
                    log.info("Running dynamic report job");
                    reportService.generateScheduledReport();
                },
                // Trigger — re-evaluated before each execution
                triggerContext -> {
                    String cronExpression = configRepository
                            .findByKey("report.cron")
                            .map(ScheduleConfig::getValue)
                            .orElse("0 0 2 * * *");  // Default: 2 AM daily

                    log.debug("Next report schedule: {}", cronExpression);
                    return new CronTrigger(cronExpression)
                            .nextExecution(triggerContext);
                }
        );
    }
}