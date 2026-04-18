package com.darkness.tutorial.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "schedule_configs")
@Data
public class ScheduleConfig {

    @Id
    private String key;          // e.g., "report.cron"

    @Column(nullable = false)
    private String value;        // e.g., "0 0 3 * * *"

    private String description;

    @UpdateTimestamp
    private Instant updatedAt;
}