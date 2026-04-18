package com.darkness.tutorial.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class InventoryService {
    public void synchronize() {
        log.info("Starting synchronize at {}", Instant.now());
    }
}
