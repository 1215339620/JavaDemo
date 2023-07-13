package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo5 {
    public static void main(String[] args) throws Exception {
        //注册驱动（可省略）
        //Class.forName("com.mysql.jdbc.Driver");
        //获取链接，如果连接的是本机的数据库，并且默认的端口是3306，可以简化书写
        String url="jdbc:mysql:///mgy";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        //定义sql
        String sql="select * from account";
        //获取statement
        Statement statement  = connection.createStatement();
        //执行SQL
        ResultSet rs=statement.executeQuery(sql);
        //处理结果，遍历所有数据
        while (rs.next()){
            int id= rs.getInt(1);
            String name = rs.getString(2);
            int money= rs.getInt(3);
            System.out.print(id+" | "+name+" | "+money);
            System.out.println();
        }
        //释放资源
        rs.close();
        statement.close();
        connection.close();
    }
}
