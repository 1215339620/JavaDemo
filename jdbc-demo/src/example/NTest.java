package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;
import project.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NTest {
    //查询所有数据
    @Test
    public void testSelectAll() throws Exception {
        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        //定义sql
        String sql="select * from tb_brand";
        //获取
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //执行SQL
        ResultSet rs=pstmt.executeQuery();
        //创建集合
        List<Brand> list=new ArrayList<>();

        //处理结果，遍历所有数据
        Brand brand=null;
        while (rs.next()){
            int id= rs.getInt("id");
            String brandName= rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //封装对象
            brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);



            //存入集合
            list.add(brand);
        }
        System.out.println(list);
        //释放资源
        rs.close();
        pstmt.close();
        connection.close();
    }

    //添加
    @Test
    public void testAdd() throws Exception {
        //模拟接收数据
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1;
        String description="绕地球一圈";
        int status=1;

        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        //定义sql
        String sql="insert into tb_brand(brand_name, company_name, ordered, description, status) VALUES(?,?,?,?,?)";
        //获取
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        //执行SQL
        int count= pstmt.executeUpdate();
        //处理结果
        if (count>0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        //释放资源
        pstmt.close();
        connection.close();
    }
    //修改
    @Test
    public void testUpate() throws Exception {
        //模拟接收数据
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1;
        String description="绕地球三圈";
        int status=1;
        int id=4;

        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        //定义sql
        String sql="update tb_brand\n"+
                "      set brand_name=?,\n"+
                "      company_name  =?,\n"+
                "      ordered        =?,\n"+
                "      description   =?,\n"+
                "      status        =?\n  "+
                "    where id        = ?";
        //获取
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        //执行SQL
        int count= pstmt.executeUpdate();
        //处理结果
        if (count>0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        //释放资源
        pstmt.close();
        connection.close();
    }

    //删除
    @Test
    public void testDelete() throws Exception {
        //模拟接收数据

        int id=4;

        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        //定义sql
        String sql="delete from tb_brand where id=?";
        //获取
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //设置参数
        pstmt.setInt(1,id);

        //执行SQL
        int count= pstmt.executeUpdate();
        //处理结果
        if (count>0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        //释放资源
        pstmt.close();
        connection.close();
    }
}
