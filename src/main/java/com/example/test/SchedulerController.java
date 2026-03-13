package com.example.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduler")
public class SchedulerController {

    private final ScheduleConfigRepository scheduleConfigRepository;

    private final DynamicSchedulerService dynamicSchedulerService;

    @PostMapping("/update-cron")
    public ResponseEntity<String> updateCron(@RequestBody CronUpdateRequest cronUpdateRequest) {

        dynamicSchedulerService.updateCronExpression(cronUpdateRequest.getTaskName(), cronUpdateRequest.getCronExpression());

        return ResponseEntity.ok("Cron expression updated successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<SchedulerEntity>> findAll() {

        List<SchedulerEntity> findAll = scheduleConfigRepository.findAll();

        System.out.println("Data available " + findAll);

        return ResponseEntity.ok(findAll);

    }


}
