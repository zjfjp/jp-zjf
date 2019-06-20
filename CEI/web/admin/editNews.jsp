<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/17
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/newsServlet?op=updateNews&id=${news.id}" method="post">

    <table border="1" width="600">

        <tr>
            <td>修改新闻标题</td>
            <td><input name="title" type="text" value="${news.title}" ></td>
        </tr>
        <tr>
            <td>修改新闻描述</td>
            <td><input name="description" type="text" value="${news.description}" ></td>
        </tr>
        <tr>
            <td>修改新闻作者</td>
            <td><input name="author" type="text" value="${news.author}"></td>
        </tr>
        <tr>
            <td>修改新闻内容</td>
            <td><input name="content" type="text" value="${news.content}" ></td>
        </tr>
        <tr>
            <td>修改新闻发布时间</td>
            <td><input name="createTime" type="text" value="${news.createTime}" ></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改" ></td>
        </tr>

    </table>

</form>
</body>
</html>
