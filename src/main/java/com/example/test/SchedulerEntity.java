package com.example.test;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "schedule-config")
public class SchedulerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String cronExpression;
}
