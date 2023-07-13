package mai.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

//        //1.设置响应状态码302
//        response.setStatus(302);
//        //2.设置响应头
//        response.setHeader("Location","/tomcatDemo/resp2");

        //简化方法完成重定向
        response.sendRedirect("/tomcatDemo/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
