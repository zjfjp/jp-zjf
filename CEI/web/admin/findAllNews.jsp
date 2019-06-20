<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/newsServlet?op=findAllNews">
    <table border="1px" width="500px">
        <tr>
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>新闻描述</th>
            <th>新闻作者</th>
            <th>新闻内容</th>
            <th>创建时间</th>
            <th>新闻点击量</th>
            <th>新闻栏目</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.title}</td>
                <td>${l.description}</td>
                <td>${l.author}</td>
                <td>${l.content}</td>
                <td>${l.createTime}</td>
                <td>${l.click}</td>
                <td>${l.columns}</td>

                <td><a href="JavaScript:delNews('${l.id}')">删除</a></td>
                <td><a href="${pageContext.request.contextPath}/newsServlet?op=editNews&id=${l.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>

    <script>
    function delNews(id) {
        var sure = confirm("你确定要删除这则新闻吗？");
        if(sure){
            window.location.href="${pageContext.request.contextPath}/newsServlet?op=delNews&id="+id;

        }else{
            alert("不删除");
        }

    }
</script>

