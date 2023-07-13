<%@ page import="mai.User" %><%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/27
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="mai.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
  <%
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      User user=new User(username,password);
      if ("zhangsan".equals(user.getUsername())&&"123".equals(user.getPassword())){
          out.println("登陆成功！");
      }else {
          out.println("登陆失败！");
      }
  %>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
