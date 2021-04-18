package com.yell.springboot.config;

import com.yell.springboot.jobs.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 *
 */
//@Configuration
public class QuartzConfig {

    // 创建 JobDetail 实例
    @Bean
    public JobDetail getJobDetail() {
        // JobBuilder: 定义和创建 JobDetail 实例的接口
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    // 触发器的定义
    @Bean
    public Trigger trigger01() {
        // 创建 scheduleBuilder
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 每一秒执行一次
                .withIntervalInSeconds(1)
                // 永久循环
                .repeatForever();

        // TriggerBuilder: 定义和创建Trigger实例的接口
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger01", "group01")
                .withSchedule(simpleScheduleBuilder)
                .forJob(getJobDetail())
                .build();

        return trigger;
    }

    @Bean
    public Trigger trigger02() {
        // 创建Corn表达式ScheduleBuilder (每五秒执行一次)
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger02", "group01")
                .withSchedule(cronScheduleBuilder)
                .forJob(getJobDetail())
                .build();
        return trigger;
    }

}
