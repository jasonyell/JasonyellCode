package com.yell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @program: springboot02
 * @description
 * @author: JasonYell
 * @create: 2021-04-07 16:15
 **/
@Configuration //配置类
@ComponentScan("com.yell.controller")  //扫描包范围
@EnableWebMvc //在设置通过 @Configuration 注解的类上添加，表示启用MVC环境
public class MvcConfig extends WebMvcConfigurationSupport {
    /**
     * 配置 JSP 视图解析器
     * @return
     */
    @Bean // 表示返回的视图解析器对象,交给IOC 进行维护
    public InternalResourceViewResolver viewResolver() {
        // 得到视图解析器对象
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        //设置视图的前缀
        viewResolver.setPrefix("/WEB-INF/views/");
        //设置文件后缀
        viewResolver.setSuffix(".jsp");

        // 返回视图解析器（交给 IOC 维护）
        return viewResolver;
    }

    /**
     * 拦截器的配置
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
