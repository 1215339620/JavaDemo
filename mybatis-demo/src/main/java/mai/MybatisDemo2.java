package mai;

import mai.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象，执行Sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //3.执行SQL
//        List<User>  users= sqlSession.selectList("test.selectAll");
        //3.1获取接口代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=userMapper.selectAll();

        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
