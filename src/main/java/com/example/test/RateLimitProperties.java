package com.example.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "ratelimit")
public class RateLimitProperties {

    private List<RateLimitConfig> configs;

    public List<RateLimitConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<RateLimitConfig> configs) {
        this.configs = configs;
    }
}
