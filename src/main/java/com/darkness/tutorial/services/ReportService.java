package com.darkness.tutorial.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class ReportService {
    public void generateDaily() {
        log.info("Starting generate daily at {}", Instant.now());
    }

    public void generateForRegion(String region) {
        log.info("Starting generate ForRegion at region {} and at {}", region, Instant.now());
    }

    public void generateScheduledReport() {
        log.info("Starting generate Scheduled Report at {}", Instant.now());
    }
}
