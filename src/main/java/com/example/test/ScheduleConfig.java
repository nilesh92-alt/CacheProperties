package com.example.test;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
public class ScheduleConfig {
    private String taskName;
    private String cronExpression;
}
