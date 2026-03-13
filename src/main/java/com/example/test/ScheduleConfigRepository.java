package com.example.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleConfigRepository extends JpaRepository<SchedulerEntity, Long> {


    public Optional<SchedulerEntity> findByTaskName(String taskName);
}
