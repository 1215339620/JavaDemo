<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="info.jsp" method="post">
    <table width="260px" height="100px" border="1" align="center">
        <tr>
            <td colspan="2" align="center">
                <b>添加图书信息</b>
            </td>
        </tr>
        <tr>
            <td>名 称：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>作 者：</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>价 格：</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
