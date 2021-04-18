package com.yell.config;

import com.yell.dao.AccountDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */

@Configuration  //标记当前类作为一个配置类，相当于xml配置文件 组合注解
@ComponentScan(value = "com.yell")  // 设置扫描包的范围
public class IocConfig02 {

    /**
     *  一般用于继承第三方框架或组件，比如：数据源、视图解析器等(只需要实例化一次的bean对象)
     *  通过 @Bean 注解的方法，方法的返回值会交给IOC进行维护(返回的accountDao会交给IOC实例化，也是一个单例)
     * @return
     */
    @Bean
    public AccountDao accountDao() {
        return new AccountDao();
    }

}
