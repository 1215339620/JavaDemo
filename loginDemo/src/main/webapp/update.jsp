<%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/18
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brandDemo/updateServlet" method="post">
<%--    隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序   ：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态   ：
<c:if test="${brand.status==1}">
    <input type="radio" name="status" value="1" checked>启用
    <input type="radio" name="status" value="0">禁用<br>
</c:if>
    <c:if test="${brand.status!=1}">
        <input type="radio" name="status" value="1" >启用
        <input type="radio" name="status" value="0" checked>禁用<br>
    </c:if>


    <input type="submit" value="提交">

</form>
</body>
</html>
