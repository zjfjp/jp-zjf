<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/24
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<table border="1" width="500">

    <tr>
        <td>编号</td>
        <td>标题</td>
        <td>作者</td>
        <td>内容</td>
        <td>时间</td>
        <td>类型</td>
        <td>操作</td>

    <tr>
        <td>${news.id}</td>
        <td>${news.title}</td>
        <td>${news.author}</td>
        <td>${news.content}</td>
        <td>${news.createTime}</td>
        <td>${news.columnid}</td>
        <td>
            <a href="JavaScript:delNews('${news.id}')">删除</a>
            <a href="${pageContext.request.contextPath}/newsServlet?op=editNews&id=${news.id}">修改</a>
        </td>
    </tr>

</table>
</body>
</html>
