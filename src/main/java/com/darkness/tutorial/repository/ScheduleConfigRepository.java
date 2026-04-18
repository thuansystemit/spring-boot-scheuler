package com.darkness.tutorial.repository;

import com.darkness.tutorial.models.ScheduleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleConfigRepository extends JpaRepository<ScheduleConfig, Long> {
    Optional<ScheduleConfig> findByKey(String key);
}
