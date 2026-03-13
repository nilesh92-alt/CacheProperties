package com.example.test;

import lombok.Data;

@Data
public class RateLimitConfig {

    private String webhookUrl;
    private int limit;
}
