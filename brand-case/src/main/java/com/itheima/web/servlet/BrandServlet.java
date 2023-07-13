package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService=new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        List<Brand> brands = brandService.selectAll();
        //转为JSON
        String jsonString = JSON.toJSONString(brands);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接受品牌数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service完成添加
        brandService.add(brand);
        //响应成功的标识
        response.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        response.getWriter().write("success");

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //处理Post请求乱码问题
        request.setCharacterEncoding("utf-8");

        String id=request.getParameter("id");
        System.out.println(id);
        //封装一个Brand对象
//        Brand brand = new Brand();
//        brand.setId(Integer.parseInt(id));
        int idd = Integer.parseInt(id);
        //2.调用service完成添加
//        brandService.delete(brand);

        brandService.deleteById(idd);
        //响应成功的标识
        response.getWriter().write("success");
    }

}
