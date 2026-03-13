package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebhookService {

    private final RateLimitCache rateLimitCache;

    public Integer checkRateLimit(String webhookUrl) {

        Integer limit = rateLimitCache.getLimit(webhookUrl);
        System.out.println("Final output : " + rateLimitCache.getAll());

        System.out.println("Rate limit for " + webhookUrl + " = " + limit);

        return limit;
    }
}
