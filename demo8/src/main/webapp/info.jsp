<%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/27
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="book" class="mai.Book"></jsp:useBean>
<jsp:setProperty name="book" property="*"></jsp:setProperty>
<ul>
    <li>
        图书名称：<jsp:getProperty name="book" property="name"></jsp:getProperty>
    </li>
    <li>
        图书作者：<jsp:getProperty name="book" property="author"></jsp:getProperty>
    </li>
    <li>
        图书价格：<jsp:getProperty name="book" property="price"></jsp:getProperty>
    </li>
</ul>
</body>
</html>
