package mai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        //获取所有参数map集合
        Map<String,String[]> map= req.getParameterMap();
        for (String key: map.keySet()) {
            System.out.print(key+":");
            String[] values=map.get(key);
            for (String value: values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        String[] hobbies=req.getParameterValues("hobby");
        for (String hobby:hobbies
             ) {
            System.out.println(hobby);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);

////获取所有参数map集合
//        Map<String,String[]> map= req.getParameterMap();
//        for (String key: map.keySet()) {
//            System.out.print(key+":");
//            String[] values=map.get(key);
//            for (String value: values) {
//                System.out.print(value+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------");
//        String[] hobbies=req.getParameterValues("hobby");
//        for (String hobby:hobbies
//        ) {
//            System.out.println(hobby);
//        }
    }
}
