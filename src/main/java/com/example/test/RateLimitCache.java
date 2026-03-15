package com.example.test;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class RateLimitCache {

    private final RateLimitProperties rateLimitProperties;

    private final ConcurrentHashMap<String, Integer> rateLimitMap = new ConcurrentHashMap<>();



    @PostConstruct
    public void init() {

        if (rateLimitProperties.getConfigs() == null) {
            System.out.println("No rate limit configs found");
            return;
        }

//        rateLimitProperties.getConfigs()
//                .forEach(config ->
//                        rateLimitMap.put(config.getWebhookUrl(), config.getLimit())
//                );

        rateLimitProperties.getConfigs().forEach((webhook, config) ->
                rateLimitMap.put(webhook, config.getLimit())
        );

        System.out.println("Into init method of rateLimit");

        System.out.println("loading data" + rateLimitMap);
    }

    @Cacheable(value = "customerLimit", key = "#webhookUrl")
    public Integer getLimit(String webhookUrl) {
        System.out.println("Getting limit from the map");
        return rateLimitMap.get(webhookUrl);
    }

    public Map<String, Integer> getAll() {
        return rateLimitMap;
    }
}