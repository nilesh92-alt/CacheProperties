package com.example.test;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class RateLimitCache {

    private final RateLimitProperties rateLimitProperties;

    private final ConcurrentHashMap<String, Integer> rateLimitMap = new ConcurrentHashMap<>();


    @PostConstruct
    public void init() {

        rateLimitProperties.getConfigs()
                .forEach(config ->
                        rateLimitMap.put(config.getWebhookUrl(), config.getLimit())
                );

        System.out.println("loading data" + rateLimitMap);
    }

    public Integer getLimit(String webhookUrl) {
        return rateLimitMap.get(webhookUrl);
    }

    public Map<String, Integer> getAll() {
        return rateLimitMap;
    }
}