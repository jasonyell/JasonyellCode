package com.yell.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */

@Configuration  //标记当前类作为一个配置类，相当于xml配置文件 组合注解
@ComponentScan(value = "com.yell")  // 设置扫描包的范围
public class IocConfig {

}
