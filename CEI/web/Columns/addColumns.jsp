<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/headers.jsp"  %>
<br/>
<html>
<head>
    <title>添加栏目</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/columnsServlet?op=addColumns" method="post" >
    <table border="1">
        <!-- 第1行  -->
        <tr>
            <td>栏目名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加栏目"></td>
        </tr>
    </table>
</form>
</body>
</html>
