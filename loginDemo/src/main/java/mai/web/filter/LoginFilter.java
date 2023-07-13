package mai.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        //判断访问资源路径是否和登陆注册相关
        String[] urls={"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","registerServlet","/checkCodeServlet"};
//        获取当前访问路径
        String url = req.getRequestURL().toString();
        for (String u:urls
             ) {
            if (url.contains(u)){
                //放行
                chain.doFilter(request, response);
                return;
            }
        }

        //1.判断session中是否有user对象

        HttpSession session = req.getSession();
        Object user= session.getAttribute("user");
        //2.判断user是否为null
        if (user!=null){
            //已有user信息
            chain.doFilter(request, response);
        }else {
            //没有登录过的
            //存储错误信息到request
            req.setAttribute("login_msg","您还没有登录");
            //跳转到login.jsp
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //放行

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
