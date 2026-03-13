package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CronJobScheduler {

    //    @Scheduled(cron = "0 * * * * ?")
    public static void getEmployeeDataViaScheduler() {
        long start = System.currentTimeMillis();
        System.out.println("Into Scheduler task");
        long end = System.currentTimeMillis();
        System.out.println("processing time" + (start - end) + "ms");
        System.out.println("End method scheduler");
    }

}
