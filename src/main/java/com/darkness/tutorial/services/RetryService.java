package com.darkness.tutorial.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class RetryService {
    public void processFailedJobs() {
      log.info("Starting process failed Jobs at {}", Instant.now());
    }
}
