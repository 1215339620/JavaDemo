package mai.web;

import mai.pojo.Brand;
import mai.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理Post请求乱码问题
        request.setCharacterEncoding("utf-8");

        String brandName=request.getParameter("brandName");
        String companyName=request.getParameter("companyName");
        String ordered=request.getParameter("ordered");
        String description=request.getParameter("description");
        String status=request.getParameter("status");

        //封装一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //2.调用service完成添加
        service.add(brand);
        //3.转发到查询所有servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
