package mai.web;

import mai.pojo.Brand;
import mai.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String id=request.getParameter("id");
        //2.调用Service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        //3.存储到request中
        request.setAttribute("brand",brand);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}


