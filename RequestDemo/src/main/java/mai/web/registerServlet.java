package mai.web;

import mai.mapper.UserMapper;
import mai.pojo.User;
import mai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mybatis 完成查询
        //2.1 获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User u=userMapper.selectByUsername(username);
        if (u==null){
            //用户不存在
            userMapper.add(user);

            //提交事务,将新注册的账号存入数据量
            sqlSession.commit();
            sqlSession.close();
        }else {
            //用户存在
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
