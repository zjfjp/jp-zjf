<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/12
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--jstl标准标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻模块</title>
</head>
<body>
<table border="1" width="438">
    <c:forEach items="${list}" var="l">
    <tr>
        <td>${l.id}</td>
        <td>${l.title}</td>
        <td>${l.description}</td>
        <td>${l.author}</td>
        <td>${l.content}</td>
        <td>${l.createTime}</td>
        <td>${l.click}</td>
        <td>
            <a href="JavaScript:delNews('${l.id}')">删除</a>
            <a href="${pageContext.request.contextPath}/newsServlet?op=editNews&id=${l.id}">修改</a>
        </td>
    </tr>

    </c:forEach>
</table>
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