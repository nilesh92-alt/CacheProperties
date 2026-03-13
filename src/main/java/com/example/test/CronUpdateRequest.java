package com.example.test;

import lombok.Data;

@Data
public class CronUpdateRequest {

    private String taskName;
    private String cronExpression;


}
