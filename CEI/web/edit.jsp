<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/headers.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}columnServlet?op=editColumn&id=${c.cid}" method="post" >
    <table border="1">
        <!-- 第1行  -->
        <tr>
            <td>分类名称</td>
            <td><input type="text" name="name" value="${c.name}" ></td>
        </tr>
        <!-- 第2行  -->
        <tr>
            <td colspan="2"><input type="submit" value="修改分类"></td>
        </tr>
    </table>
</form>
</body>
</html>
