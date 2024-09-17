package com.yell.springmvc.controller;

import com.yell.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON 配置
 *  @ResponseBody
 *      默认返回的是页面，加上注解后表示返回的是JSON格式的数据
 *      注解声明：
 *          方法体上
 *          方法的返回类型前 修饰符 后
 *  @RequestBody
 *      @RequestBody接受的值是一个字符串！！！一般是JSON格式的字符串
 *      通过 @RequestBody 可以将请求体中的 JSON 字符串绑定到相应的 bean 上，当然，也可以将其分别绑定到对应的字符串上。
 */
@Controller
public class JsonController {

    /**
     *  @ResponseBody 返回的是 JSON 格式的数据，返回 JavaBean 对象
     * @return
     */
    @RequestMapping("query01")
    @ResponseBody
    public User query01() {
        User user = new User();
        user.setId(1);
        user.setUserName("jasonyell");
        user.setUserPwd("1234");
        return user;
    }

    /**
     *  @ResponseBody 返回的是 JSON 格式的数据，返回 JavaBean 对象
     *      注解设置在方法返回对象之前，修饰符之后
     * @return
     */
    @RequestMapping("query02")
    public @ResponseBody User query02() {
        User user = new User();
        user.setId(2);
        user.setUserName("yell");
        user.setUserPwd("12344444");
        return user;
    }

    /**
     * 返回的是 JSON 格式的数据，返回集合
     * @return
     */
    @RequestMapping("query03")
    @ResponseBody
    public List<User> query03() {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("admin1");
        user1.setUserPwd("1");

        User user2 = new User();
        user2.setId(1);
        user2.setUserName("admin2");
        user2.setUserPwd("2");

        User user3 = new User();
        user3.setId(1);
        user3.setUserName("admin3");
        user3.setUserPwd("3");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }


    /**
     * @RequestBody
     *      要求前台传递JSON格式的数据,一定要是字符串!!!
     * @param user
     * @return
     */
    @RequestMapping("query04")
    @ResponseBody
    public User query04(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

}
