package com.example.test;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RateLimitCache {

    private final RateLimitProperties rateLimitProperties;

    private Map<String, Integer> rateLimitMap = new HashMap<>();


    @PostConstruct
    public void init() {

        rateLimitProperties.getConfigs()
                .forEach(config ->
                        rateLimitMap.put(config.getWebhookUrl(), config.getLimit())
                );
    }

    public Integer getLimit(String webhookUrl) {
        return rateLimitMap.get(webhookUrl);
    }

    public Map<String, Integer> getAll() {
        return rateLimitMap;
    }
}