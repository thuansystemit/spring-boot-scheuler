package com.darkness.tutorial.scheduler;

import com.darkness.tutorial.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
@AllArgsConstructor
public class SampleScheduler {
    private final RetryService retryService;
    private final InventoryService inventoryService;
    private final ReportService reportService;
    private final EmailService emailService;
    private final MarketService marketService;
    @Scheduled(fixedDelay = 5000)  // Run every 5 seconds after previous run completes
    public void runTask() {
        log.info("Scheduled task executed at {}", Instant.now());
    }

    // Runs 5 seconds AFTER the previous run finishes
    @Scheduled(fixedDelay = 5000)
    public void processRetryQueue() {
        retryService.processFailedJobs();
    }

    // With initial delay — waits 10s before first execution
    @Scheduled(fixedDelay = 5000, initialDelay = 10000)
    public void processWithDelay() {
        retryService.processFailedJobs();
    }

    @Scheduled(fixedRate = 10000)
    public void syncInventory() {
        inventoryService.synchronize();
    }

    // Every day at 2:00 AM
    @Scheduled(cron = "0 0 2 * * *")
    public void generateDailyReport() {
        reportService.generateDaily();
    }

    // Every Monday at 8:30 AM
    @Scheduled(cron = "0 30 8 * * MON")
    public void sendWeeklyDigest() {
        emailService.sendWeeklyDigest();
    }

    // Run at 2:00 AM in a specific timezone — critical for global deployments
    @Scheduled(cron = "0 0 2 * * *", zone = "Asia/Ho_Chi_Minh")
    public void generateAsiaReport() {
        reportService.generateForRegion("APAC");
    }

    @Scheduled(cron = "0 0 9 * * MON-FRI", zone = "America/New_York")
    public void runNYMarketOpen() {
        marketService.processOpeningJobs();
    }
}
