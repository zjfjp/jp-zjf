<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <style type="text/css">

    </style>

</head>
<body>
<h3 align="center" style="font-size: 22px"> 	${sessionScope.u.username}新闻后台基本操作
</h3>

<a href="${basePath}/Column/addColumn.jsp">添加分类</a>
&nbsp;
<a href="${basePath}/columnServlet?op=findAllColumn">查询分类</a>
&nbsp;
<a href="${basePath}/newsServlet?op=goToAddNewsView">添加新闻</a>
&nbsp;
<a href="${basePath}/newsServlet?op=findAllNews">查询新闻</a>
</body>
</html>
