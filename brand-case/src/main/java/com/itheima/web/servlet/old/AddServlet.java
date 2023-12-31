package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService=new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
