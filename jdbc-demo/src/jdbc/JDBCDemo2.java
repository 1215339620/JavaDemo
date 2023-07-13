package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
        //注册驱动（可省略）
        //Class.forName("com.mysql.jdbc.Driver");
        //获取链接，如果连接的是本机的数据库，并且默认的端口是3306，可以简化书写
        String url="jdbc:mysql:///mgy";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        //定义SQL
        String sql="update account set money=2 000 where id =1";
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
