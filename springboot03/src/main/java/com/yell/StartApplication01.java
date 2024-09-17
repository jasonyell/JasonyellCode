package com.yell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * springboot项目启动类
 */

@SpringBootApplication
public class StartApplication01 {

    // 添加日志对象
    private static Logger logger = LoggerFactory.getLogger(StartApplication01.class);

    public static void main(String[] args) {
        //启动 spring boot 项目
        SpringApplication.run(StartApplication01.class);

        // 使用日志  {} 相当于占位符
        logger.info("正在使用日志...{}","admin");

        // 得到一个SpringApplication对象
//        SpringApplication springApplication = new SpringApplication(StartApplication01.class);
        //关闭Banner图表
//        springApplication.setBannerMode(Banner.Mode.OFF);
        // 启动项目
//        springApplication.run();
    }
}
