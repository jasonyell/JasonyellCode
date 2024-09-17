package com.yell.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springmvc01
 * @description
 * @author: JasonYell
 * @create: 2021-04-03 01:57
 **/
@Controller
public class helloController {

    /**
     * 通过 @RequestMapping("hello") 绑定访问的URL
     *      匹配路径是 hello.do 的URL （web.xml 中拦截的配置）
     *      http://localhost:8080/springmvc01/hello.do
     * @return
     */
    @RequestMapping("hello")
    public ModelAndView hello() {

        System.out.println("目标方法。。。");
        // 得到 modelandview 对象
        ModelAndView modelAndView = new ModelAndView();

        // 设置模型
        modelAndView.addObject("hello", "Hello SpringMVC");

        // 设置视图（视图名称)
        modelAndView.setViewName("hello");  //会去查找一个 hello 的 jsp 页面

        // 返回模型视图
        return modelAndView;
    }
}
