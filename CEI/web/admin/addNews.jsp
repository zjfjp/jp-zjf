<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/newsServlet?op=addNews" method="post">
    <table>
        <tr>
            <td>新闻标题</td>
            <td>
                <input type="text" name="title">
            </td>
        </tr>
        <tr>
            <td>新闻内容</td>
            <td>
                <input type="text" name="content">
            </td>
        </tr>
        <tr>
            <td>新闻描述</td>
            <td>
                <input type="text" name="description">
            </td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>
                <input type="yy-mm-dd" name="createTime">
            </td>
        </tr>
        <tr>
            <td>新闻作者</td>
            <td>
                <input type="text" name="author">
            </td>
        </tr>
    </table>
    <input type="submit" value="添加新闻">
</form>
</body>
</html>
