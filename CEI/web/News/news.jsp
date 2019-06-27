<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div{
            position: absolute;
            top: 50px;
            left: 650px;
        }
    </style>
</head>
<body>
<table border="1" width="600px" bordercolor="#6699FF">
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>作者</th>
        <th>内容</th>
        <th>时间</th>
        <th>点击</th>
        <th>所属分类</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="l" >

        <tr>

            <td>${l.id}</td>
            <td>${l.title}</td>
            <td>${l.author}</td>
            <td>${l.content}</td>
            <td>${l.createTime}</td>
            <td>${l.click}</td>
            <td>${l.name}</td>
            <td>
                <a href="JavaScript:delNews('${l.id}')">删除</a>
                <a href="${pageContext.request.contextPath}/newsServlet?op=editNews&id=${l.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <form action="${pageContext.request.contextPath}/newsServlet?op=findNewsById" method="post">
        <input type="text" name="id" >
        <br />
        <br />
        <input type="submit" value="根据ID查询" >
    </form>
    <form action="${pageContext.request.contextPath}/newsServlet?op=findNewsByName" method="post">
        <input type="text" name="author" >
        <br />
        <br />
        <input type="submit" value="根据作者查询">
    </form>
    <form action="${pageContext.request.contextPath}/newsServlet?op=findNewsByLike" method="post">
        <input type="text"  name="ntitle">
        <br />
        <br />
        <input type="submit" value="根据模糊查询">
    </form>

</div>
</body>
</html>
<script>
    function delNews(id) {
        var sure=confirm("你确定要删除吗");
        if (sure){
            window.location.href="${pageContext.request.contextPath}/newsServlet?op=delNews&id="+id;
        } else{
            alert("no");
        }
    }
</script>