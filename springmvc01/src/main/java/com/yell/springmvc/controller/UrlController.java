package com.yell.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 *  URL 地址映射配置
 *      @RequestMapping("映射地址")
 *      声明在方法上，表示请求路径与类中的方法绑定
 *      声明在类级别上，表示请求的路径和类绑定
 *
 *      常用形式：
 *          方法路径     /方法路径
 *          类路径 + 方法绑定   /类路径/方法路径
 *
 */

@Controller
@RequestMapping("url")
public class UrlController {

    /**
     * @RequestMapping 声明方法上面，映射单个 URL
     * 访问地址：（如果有类路径需要写在方法路径前面）
     * http://ip:port/springmvc01/test01
     * @return
     */
    @RequestMapping("url01")
    public ModelAndView url01() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url01");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    /**
     * 路径开头是否加 斜杠"/" 均可
     *  @RequestMapping("/请求路径") 与 @RequestMapping("请求路径")均可
     *  建议加上，如：@RequestMapping("/test02")
     *  访问地址：（如果有类路径需要写在⽅法路径前⾯）
     * http://ip:port/springmvc01/test02
     * @return
     */
    @RequestMapping("url02")
    public ModelAndView url02() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url02");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * @RequestMapping 声明在方法上面，映射多个 URL
     *  支持一个方法绑定多个 url 的操作
     *  访问地址：（如果有类路径需要写在方法路径前面）
     *  http://ip:port/springmvc01/test03_01
     *  http://ip:port/springmvc01/test03_02
     * @return
     */
    @RequestMapping(value = {"url01_01","url03_02"})
    public ModelAndView url03() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url03");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * @RequestMapping 声明在类上面，类中的的方法都是以该地址作为父路径
     * 声明级别：
     * 类级别 + 方法级别 （/类路径/方法路径）
     * 访问地址：
     * http://ip:port/springmvc01/url/test04
     * @return
     */
    @RequestMapping("url04")
    public ModelAndView url04() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url04");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * 设置请求方式
     * 通过 method 属性设置⽅法⽀持的请求⽅式，默认 GET请求和 POST等请求都⽀持。
     * 设置了请求⽅式，则只能按照指定的请求⽅式请求。
     * 访问地址：（只能使⽤POST请求访问）
     * http://ip:port/springmvc01/url/test05
     * @return
     */
    @RequestMapping(value = "url05" ,method = RequestMethod.POST)
    public ModelAndView url05() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url05");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * 通过参数名称访问
     * 通过参数的形式访问
     * 访问地址：
     * http://ip:port/springmvc01/url?test06
     * @return
     */
    @RequestMapping(params = "url06")
    public ModelAndView url06() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "url06");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
