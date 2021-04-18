package com.yell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 添加容器启动加载文件 (类似于读取 web.xml)，这里通过继承 SpringBootServletInitializer 类并重写 configure 方法来
 * 实现，在部署项目时指定外部 Tomcat 读取项目入口方法。
 */
@SpringBootApplication
public class starter02 extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(starter02.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(starter02.class);
    }

}
