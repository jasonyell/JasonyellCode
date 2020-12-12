package jasonyell.config.interceptoe;

import com.fasterxml.jackson.databind.ObjectMapper;
import jasonyell.base.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @program: javaee-study
 * @description
 * @author: JasonYell
 * @create: 2020-12-12 03:02
 **/
public class LoginInterceptor implements HandlerInterceptor {
    private ObjectMapper objectMapper;

    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * if(session != null && session.getAtribute("user") != null) return true; ===》 继续执行
     * else 返回一个带错误码 和 错误信息的 json
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true;   // 登录，继续执行 Controller 中的方法
        }

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding("utf-8");

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        // 前端通过状态码已经处理了，可以不反应响应体内容
        ResponseResult r = ResponseResult.error("SES000", "用户没有登录");
        PrintWriter pw = response.getWriter();
        pw.printf(objectMapper.writeValueAsString(r));
        pw.flush();

        return false;
    }
}
