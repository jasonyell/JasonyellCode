package jasonyell.controller;

import jasonyell.model.Setting;
import jasonyell.model.User;
import jasonyell.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    /**
     *  cookie 中携带 tomcat 的 session 实现，也就是请求头包含 Cookie ： JESSIONID=xxx
     *  比如服务器重启，或没有登录 但携带 JSESSIONID 的信息， 获取 HttpSession 对象不为空
     *  此时要判断设置的 key 和 值，判断之不为空才是登录的
     *  如果不实现拦截器，需要保证以上的逻辑
     *  如果实现拦截器，一定登录之后 才允许访问接口
     *
     * @param session
     * @return
     */
    @GetMapping("/query")
    public Object query(HttpSession session) {
        // 登录以后才能访问接口，从会话中获取保存的用户信息
        User user = (User) session.getAttribute("user");
        Setting setting = settingService.query(user.getId());
        setting.setUser(user);
        return setting;
    }
}
