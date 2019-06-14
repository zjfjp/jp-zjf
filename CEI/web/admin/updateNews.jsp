<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/12
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/newsServlet?op=updataNews&id=${news.id}">

    <table border="1" align="center">
        <tr>
            <td>标题</td>
            <td>
                <input type="text" name="title">
            </td>
        </tr>
        <tr >
            <td>内容</td>
            <td colspan="3" rowspan="5">
                <input type="text" name="content">
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td colspan="2" rowspan="2">
                <input type="text" name="description">
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td>
                <input type="text" name="author">
            </td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>
                <input type="datetime-local" name="createTime">
            </td>
        </tr>

        <tr align="center">
            <td colspan="2">
                <input type="submit" value="修改新闻">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
