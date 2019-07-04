<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>
<%@ include file="/headers.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${basePath}">所有分类</a>
<c:forEach items="${cs}" var="c">
    <a href="${basePath}/columnsServlet?op=showColumnsNews&columnid=${c.cid}">${c.name}</a>
</c:forEach>
<table border="1">
    <tr>
        <c:forEach items="${page.records}" var="l">
            <td>

                标题：${l.title}<br />
                作者: ${l.author }<br />
                发布时间：${l.createTime}<br />
                所属类别：${l.columnid}<br />

                </a>
            </td>
        </c:forEach>
    </tr>
</table>
<%@include file="/common/page.jsp"%>
</body>
</html>
