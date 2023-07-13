package mai.web;

import mai.pojo.Brand;
import mai.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理Post请求乱码问题
        request.setCharacterEncoding("utf-8");

        String id=request.getParameter("id");

        //封装一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));

        //2.调用service完成更新
        service.delete(brand);
        //3.转发到查询所有servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
