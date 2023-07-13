package jdbc;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo4 {
    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void testDMl() throws Exception {
        //获取链接，如果连接的是本机的数据库，并且默认的端口是3306，可以简化书写
        String url="jdbc:mysql:///mgy";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        //定义SQL
        String sql="update account set money=3000 where id =1";
        //获取执行sql的对象   statement
        Statement statement =connection.createStatement();
        //执行sql
        int count=statement.executeUpdate(sql);
        //处理结果,count代表执行SQL语句影响到的行数
//        System.out.println(count);
        if (count>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        //释放资源
        statement.close();
        connection.close();
    }

    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void testDDl() throws Exception {
        //获取链接，如果连接的是本机的数据库，并且默认的端口是3306，可以简化书写
        String url="jdbc:mysql:///mgy";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        //定义SQL
        String sql="insert into account values(3,'王五',3000)";
        //获取执行sql的对象   statement
        Statement statement =connection.createStatement();
        //执行sql
        int count=statement.executeUpdate(sql);
        //处理结果,count代表执行SQL语句影响到的行数
//        System.out.println(count);
        if (count>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        //释放资源
        statement.close();
        connection.close();
    }

}
