package com.example.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "ratelimit")
@Data
public class RateLimitProperties {

//    private List<RateLimitConfig> configs;

    private Map<String, RateLimitConfig> configs;

}
