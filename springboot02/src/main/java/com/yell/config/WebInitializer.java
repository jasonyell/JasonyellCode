package com.yell.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 *  当容器启动时每回调用接口中对应的 onStartup 方法
 *      替代了 web.xml 文件
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 基于java配置类 加载spring的上线文环境
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // 注册MVC config 注册类
        ctx.register(MvcConfig.class);

        //设置 ServletContext 的上下文
        ctx.setServletContext(servletContext);

        // 得到中央控制器
        Servlet dispatcherServlet = new DispatcherServlet(ctx);

        // 设置转发器
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",dispatcherServlet);

        //设置路径
        servlet.addMapping("/");

        //设置容器启动时自动加载 servlet
        servlet.setLoadOnStartup(1);

    }
}
