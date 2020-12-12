package jasonyell.controller;

import jasonyell.model.User;
import jasonyell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;// 注意一定要在类型上加上 @Service 注册到容器中

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        // 如果用户名 密码校验失败，在service中跑一场 这里 exist 一定不为null
        User exist = userService.login(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);
        return null;
    }
}
