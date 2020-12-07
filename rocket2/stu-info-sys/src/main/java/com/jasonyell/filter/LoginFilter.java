package com.jasonyell.filter;

import com.jasonyell.model.Response;
import com.jasonyell.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @program: Fo
 * @description
 * @author: JasonYell
 * @create: 2020-11-09 15:46
 **/
/**
 * 配置了过滤器，只要请求路径匹配到过滤器路径，都会限制性过滤器的 doFilter 方法，
 * 至于是否往后边的顺序执行，依赖是否再次调用filterChain.doFilter 方法
 *
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //后台接口：只校验除登录接口之外的后台接口，没有登录时，不允许访问
        //前端资源：只校验/public/page/main.html首页，其他的都放行
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getServletPath();

        HttpSession session = req.getSession(false);//没有session的时候，返回null
        if(session == null){
            //首页重定向到登陆页面，如果后端接口，返回错误的json数据
//            req.setCharacterEncoding("UTF-8");
//            res.setCharacterEncoding("UTF-8");
            //首页重定向到登陆页面
            if("/public/page/main.html".equals(uri)){
                res.setContentType("text/html; charset=UTF-8");
                String schema = req.getScheme();    //http
                String host = req.getServerName();  //服务器ip
                int port = req.getServerPort();     //端口号
                String ctx = req.getContextPath();  //项目部署路径，应用上下文sis
//                res.sendRedirect("/public/index.html");  //这种写法跳转会出问题？
//                res.sendRedirect("public/index.html");   //这种写法跳转会出问题？
                String basePath = schema + "://" + host + ":" + port + ctx;
                res.sendRedirect(basePath+"/public/index.html");//这种写法跳转会出问题？
                return;
                //请求后端非登录接口：未登录不允许访问的请求，一般返回401状态码
            }else if((!uri.startsWith("/public/")
                    && !uri.startsWith("/static/") && !"/user/login".equals(uri))){
                res.setContentType("application/json");
                PrintWriter pw = res.getWriter();
                Response r = new Response();
                r.setCode("ERR401");
                r.setMessage("不允许访问");
                res.setStatus(401);
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
