<%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/17
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username},欢迎您</h1>
<hr>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="status">

        <tr align="center">
            <th>${status.count}</th>
            <th>${brand.brandName}</th>
            <th>${brand.companyName}</th>
            <th>${brand.ordered}</th>
            <th>${brand.description}</th>
            <c:if test="${brand.status==1}">
                <th>启用</th>
            </c:if>
            <c:if test="${brand.status!=1}">
                <th>禁用</th>
            </c:if>
            <th><a href="/brandDemo/selectByIdServlet?id=${brand.id}">修改</a> <a href="/brandDemo/deleteServlet?id=${brand.id}">删除</a></th>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("add").onclick=function (){
        location.href="/brandDemo/addBrand.jsp";
    }
</script>
</body>
</html>
