package mai.web;

import mai.pojo.User;
import mai.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取用户名，密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //获取记住密码的复选框的值
        String remember = request.getParameter("remember");
        //2.调用service查询
        User user = service.login(username, password);
        //3.判断
        if (user!=null){
            //成功,重定向SelectAllServlet
            //判断是否勾选记住我
            if ("1".equals(remember)){
                //回显
                //创建cookie
                 Cookie c_name=new Cookie("username",username);
                 Cookie c_password=new Cookie("password",password);
                 c_name.setMaxAge(60*60*24*7);
                 c_password.setMaxAge(60*60*24*7);
                //发送
                response.addCookie(c_name);
                response.addCookie(c_password);
            }
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //虚拟目录
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else {
            //失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
