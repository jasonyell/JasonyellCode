package com.yell.springmvc.controller;

import com.yell.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *  重定向:
 *      重定向以 redirect 开头
 *      地址栏会发生改变
 *          redirect:xxx.jsp 跳转到项目目录下的 xxx.jsp页面 （项目目录下的页面,及webapp目录下）
 *          redirect:xxx     重定向跳转到某个方法路径
 *  请求转发：
 *      服务器默认请求转发
 *      以 forward 开头
 *      地址栏不发生改变
 *          forward:xxx.jsp  请求转发到 xxx.jsp（项目目录下的页面,及webapp目录下）
 *          forward:xxx      请求转发到某个方法路径
 *
 *          如果是直接设置xxx（前面不添加forward）
 *              return "hello" 或 ModelAndView.setViewName("hello")
 *              此时是请求转发跳转到hello.jsp视图，且路径是在WEB-INF目录下jsp目录（配置文件中）
 */
@Controller
public class JumpController {
    /**
     * 重定向跳转到Controller
     * 返回 ModerAndView
     */
    @RequestMapping("test01")
    public ModelAndView test01() {
        System.out.println("test01...");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:hello");

        return modelAndView;
    }

    /**
     * 重定向跳转到页面
     *  返回 ModerAndView
     */
    @RequestMapping("test02")
    public ModelAndView test02() {
        System.out.println("test02...");

        ModelAndView modelAndView = new ModelAndView();

        /**
         * 会从项目根目录上找查找页面
         */
        modelAndView.setViewName("redirect:view.jsp");

        return modelAndView;
    }

    /**
     * 重定向到 jsp 页面
     * 返回视图名称
     */
    @RequestMapping("test03")
    public String test03() {
        System.out.println("test03...");
        return "redirect:view.jsp";
    }

    /**
     * 重定向到 jsp 页面 并获取参数
     * 返回视图名称
     */
    @RequestMapping("test04")
    public String test04() {
        System.out.println("test05...");
        return "redirect:view.jsp?username=admin";
    }
    /**
     * 重定向到 jsp 页面 并获取参数
     * 返回视图名称
     */
    @RequestMapping("test05")
    public String test05() {
        System.out.println("test05...");
        return "redirect:view.jsp?username=admin&name=张三";
    }

    /**
     * 重定向到 jsp 页面 并获取参数
     * 传递参数（通过 RedirectAttributes 对象设置重定向参数，避免中文乱码问题）
     * @return
     */
    @RequestMapping("test06")
    public String test06(RedirectAttributes redirectAttributes) {
        System.out.println("test06...");
        redirectAttributes.addAttribute("username", "张三");
        redirectAttributes.addAttribute("name", "李四");
        return "redirect:view.jsp";
    }

    /**
     * 重定向到 Controller
     * @return
     */
    @RequestMapping("test07")
    public String test07() {
        System.out.println("test07...");

        return "redirect:hello"; // hello 对应的是方法的路径
    }

    /**
     * 请求转发到 jsp 页面
     * @return
     */
    @RequestMapping("test08")
    public String test08() {
        System.out.println("test08...");

        return "forward:view.jsp";
    }

    /**
     * 请求转发到 jsp 页面
     * @return
     */
    @RequestMapping("test09")
    public String test09() {
        System.out.println("test09...");

        return "forward:view.jsp?username=admin";
    }

    /**
     * 请求转发到JSP⻚面
     *      设置请求域
     */
    @RequestMapping("/test10")
    public String test10(HttpServletRequest request){
        System.out.println("test10...");
        // 设置作用域
        request.setAttribute("username","zhangsan");
        return "forward:view.jsp";
    }

    /**
     * 求转发到JSP页面（默认）
     *      默认回去制定目录下扎到jsp页面（配置文件中设置的)
     *
     * @param
     * @return
     */
    @RequestMapping("/test11")
    public String test11(){
        System.out.println("test11...");
        // 设置作用域
        return "/../../view";  // 值于WEB-INF下的jso目录中的页面名称对应(如果jsp页面不在指定目录下，需要设置到指定目录)
    }

    /**
     * 请求转发到 Controller
     * @return
     */
    @RequestMapping("/test12")
    public String test12(){
        System.out.println("test12...");
        // 设置作用域
        return "forward:hello";  //如果前面添加了 forward，则访问的是方法路径
    }

    /**
     * 请求转发到 Controller
     * @return
     */
    @RequestMapping("/test13")
    public ModelAndView test13(){
        System.out.println("test13...");
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("hello");          // jsp 视图
        modelAndView.setViewName("forward:hello");  // controller 方法

        return modelAndView;
    }

}
