package com.darkness.tutorial.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class MarketService {
    public void processOpeningJobs() {
        log.info("Starting processOpeningJobs at {}", Instant.now());
    }
}
