package mai.web;

import mai.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //生成验证码
        ServletOutputStream fos = response.getOutputStream();
        String s = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);
        //存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGet",s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
