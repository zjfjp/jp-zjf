<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/headers.jsp"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" >
    <tr>
        <th>选择</th>
        <th>分类名称</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${cs}" var="c">
        <tr>
            <td>
                <input type="checkbox" name="columns">
            </td>
            <td>
                    ${c.name}
            </td>
            <td>
                <a href="${basePath}/columnsServlet?op=editColumnsView&columnId=${c.cid}">修改</a>
                <a href="${basePath}/columnsServlet?op=delColumns&columnId=${c.cid}">删除</a>
            </td>
        </tr>


    </c:forEach>

</table>
</body>
</html>
