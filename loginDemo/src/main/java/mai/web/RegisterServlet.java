package mai.web;

import mai.pojo.User;
import mai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取账号密码信息
        String username=request.getParameter("username");
        String password = request.getParameter("password");

        //获取输入的验证码的值
        String checkCode = request.getParameter("checkCode");
        //获取生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGet = (String) session.getAttribute("checkCodeGet");


        User user =new User();
        user.setUsername(username);
        user.setPassword(password);

        if (!checkCodeGet.equalsIgnoreCase(checkCode)){
            //验证码错误，不允许注册
            request.setAttribute("register_msg","验证码输入错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        //调用service查询
        boolean b = service.register(user);
        //判断登录成功否
        if (b){
            //成功，跳转页面
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //注册失败，跳转注册页面
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
