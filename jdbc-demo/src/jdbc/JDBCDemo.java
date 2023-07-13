package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取链接
        String url="jdbc:mysql://127.0.0.1:3306/mgy";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        //定义SQL
        String sql="update account set money=1000 where id =1";
        //获取执行sql的对象   statement
        Statement statement =connection.createStatement();
        //执行sql
        int count=statement.executeUpdate(sql);
        //处理结果,count代表执行SQL语句影响到的行数
        System.out.println(count);
        //释放资源
        statement.close();
        connection.close();
    }
}
