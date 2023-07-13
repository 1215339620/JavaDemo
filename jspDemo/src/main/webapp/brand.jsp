<%@ page import="mai.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 麦
  Date: 2022/7/16
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Brand> brands=new ArrayList<Brand>();
  brands.add(new Brand(1,"三只松鼠","三只松鼠", 100, "三只松鼠，好吃不上火",1));
  brands.add(new Brand(2,"优衣库","优衣库", 200, "优衣库，服适人生",0));
  brands.add(new Brand(3,"小米","小米科技有限公司", 1000, "为发烧而生",1));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <input type="button" value="新增"><br>
  <hr>
  <table border="1" cellspacing="0" width="800">
    <tr>
      <th>序号</th>
      <th>品牌名称</th>
      <th>企业名称</th>
      <th>排序</th>
      <th>品牌介绍</th>
      <th>状态</th>
      <th>操作</th>
    </tr>

    <%
      for (int i = 0; i < brands.size(); i++) {
        Brand brand=brands.get(i);
    %>
    <tr align="center">
      <th><%=brand.getId()%></th>
      <th><%=brand.getBrandName()%></th>
      <th><%=brand.getCompanyName()%></th>
      <th><%=brand.getOrdered()%></th>
      <th><%=brand.getDescription()%></th>
      <%
        if (brand.getStatus()==1){

      %>
      <th><%="启用"%></th>
      <%
        }else {

      %>
      <th><%="禁用"%></th>
      <%
        }
      %>

      <th><a href="#">修改</a>       <a href="#">删除</a></th>
    </tr>
    <%
      }
    %>







  </table>
</body>
</html>