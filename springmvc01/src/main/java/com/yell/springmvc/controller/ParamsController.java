package com.yell.springmvc.controller;

import com.yell.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 参数绑定
 */
@Controller
public class ParamsController {

    /**
     * 基本数据类型
     * @param age
     * @param money
     */
    @RequestMapping("data01")
    public void deta01(int age, double money) {
        System.out.println(age);
        System.out.println(money);
    }

    /**
     * 基本类型数据绑定
     *   通过注解 @RequestParam 标记⼀个形参为请求参数。（注解声明在形参的前面）
     *    可以通过注解的属性设置相关内容
     *      设置参数的默认值 defaultValue
     * @param age
     * @param money
     */
    @RequestMapping("data02")
    public void deta02(@RequestParam(defaultValue = "18") int age,@RequestParam(defaultValue = "100.00") double money) {
        System.out.println(age);
        System.out.println(money);
    }

    /**
     * 基本类型数据绑定
     * 通过注解 @RequestParam 标记⼀个形参为请求参数。（注解声明在形参的前⾯）
     * 可以通过注解的属性设置相关内容
     * 设置参数的参数名（别名） name
     * @param age
     * @param money
     */
    @RequestMapping("data03")
    public void deta03(@RequestParam(defaultValue = "18", name = "uage") int age,
                       @RequestParam(defaultValue = "100.00",name = "umoney") double money) {
        System.out.println(age);
        System.out.println(money);
    }

    /**
     * 包装类型数据绑定 （如果数据是基本类型，建议使用包装类型）
     *
     * 客户端请求参数名与方法法形参名保持⼀致，默认参数值为null
     * 可以通过 @RequestParam 的name属性设置参数的别名，defaultValue属性设置参数默认值
     * @param age
     * @param money
     */
    @RequestMapping("data04")
    public void data04(Integer age, Double money){
        System.out.println("age:" + age + ", money:" + money);
    }

    /**
     * 字符串数据绑定
     * 客户端请求参数名与方法形参名保持⼀致，默认参数值为null
     * 可以通过 @RequestParam 的name属性设置参数的别名，defaultValue属性设置参数默认值
     * @param userName
     * @param userPwd
     */
    @RequestMapping("data05")
    public void data05(String userName, String userPwd){
        System.out.println("userName:" + userName + ", userPwd:" + userPwd);
    }

    /**
     * 数组类型数据绑定
     * 客户端传参形式：ids=1&ids=2&ids=3
     * @param ids
     */
    @RequestMapping("/data06")
    public void data06(String[] ids){
        System.out.println(ids.length);
    }

    /**
     * JavaBean 数据绑定
     * 客户端请求的参数名与JavaBean对象的属性字段名保持⼀致
     * @param user
     */
    @RequestMapping("/data07")
    public void data07(User user) {
        System.out.println(user);
    }

    /**
     * 集合绑定
     *  一般情况，会通过javaBean对象进行封装，传参是通过Javabean中的属性字段名设置集合的制定下标值
     */
    @RequestMapping("/data08")
    public void data08(User user) {
        System.out.println(user);
    }

    /**
     * map类型绑定
     *  一般情况下，会通过javabean对象进行封装，传参是通过Javabean中属性字段名设置map的制定key的值即可
     * @param user
     */
    @RequestMapping("/data09")
    public void data09(User user) {
        System.out.println(user);
    }


}
