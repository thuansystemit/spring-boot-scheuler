package com.darkness.tutorial.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class EmailService {
    public void sendWeeklyDigest() {
        log.info("Starting send weekly digest at {}", Instant.now());
    }
}
