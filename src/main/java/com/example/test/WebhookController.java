package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebhookController {

    private final WebhookService webhookService;


    @GetMapping("/getLimit")
    public Integer getWebhookDetail(@RequestParam String webhookUrl) {

        return webhookService.checkRateLimit(webhookUrl);
    }


}
