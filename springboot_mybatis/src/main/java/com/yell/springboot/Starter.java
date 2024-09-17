package com.yell.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 */
@SpringBootApplication
//  扫描指定包下的接口类
@MapperScan("com.yell.springboot.dao")
// 启动注解 EnCache
@EnableCaching
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class);
    }
}
