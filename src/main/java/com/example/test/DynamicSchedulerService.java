package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
public class DynamicSchedulerService {

    @Autowired
    private CronJobScheduler cronJobScheduler;

    private final ThreadPoolTaskScheduler taskExecutor = new ThreadPoolTaskScheduler();

    private ScheduledFuture<?> scheduledTask;

    @Autowired
    private ScheduleConfigRepository scheduleConfigRepository;

    DynamicSchedulerService() {
        taskExecutor.initialize();
    }

    public void updateCronExpression(String taskName, String newCronExpression) {

        SchedulerEntity schedulerEntity = scheduleConfigRepository.findByTaskName(taskName).orElse(new SchedulerEntity());
        schedulerEntity.setTaskName(taskName);
        schedulerEntity.setCronExpression(newCronExpression);
        scheduleConfigRepository.save(schedulerEntity);

        restartScheduledTask(newCronExpression);
    }

    private void restartScheduledTask(String newCronExpression) {
        if (scheduledTask != null) {
            System.out.println("First time into scheduleTask");
            scheduledTask.cancel(false);
        }
        System.out.println("Task already scheduleTask");
        scheduledTask = taskExecutor.schedule(CronJobScheduler::getEmployeeDataViaScheduler, new CronTrigger(newCronExpression) {
        });
    }
}
