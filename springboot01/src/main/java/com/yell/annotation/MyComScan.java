package com.yell.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义组合注解
 *      拥有元注解 + @Configration + @CompentScan
 *      覆盖 value 属性
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface MyComScan {
    //通过 value 属性设置扫描包范围
    String[] value() default {};
}
