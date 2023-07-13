package jdbc;

import project.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC案例1 {
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
        //创建集合
        List<Account> list=new ArrayList<>();

        //处理结果，遍历所有数据
        while (rs.next()){
            Account account=new Account();
            int id= rs.getInt(1);
            String name = rs.getString(2);
            int money= rs.getInt(3);

            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            //存入集合
            list.add(account);
        }
        System.out.println(list);
        //释放资源
        rs.close();
        statement.close();
        connection.close();
    }
}
