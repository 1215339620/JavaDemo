<%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/16
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${status==1}">
    启用
</c:if>
<c:if test="${status==0}">
    禁用
</c:if>

</body>
</html>
