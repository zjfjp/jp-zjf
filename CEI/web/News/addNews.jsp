<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/21
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jsp"%>
<%@ include file="/headers.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/newsServlet?op=addNews" method="post">
    <table border="1">
        <tr>
            <td>标题</td>
            <td>
                <input type="text" name="title" />
            </td>
        </tr>
        <br/>
        <tr>
            <td>分类</td>
            <td>
                <select style="width: 170px; height: 23px;" name="columnid">

                    <c:forEach items="${list}" var="item">

                        <option  value="${item.cid}">${item.name}</option>

                    </c:forEach>
                </select>

            </td>
        </tr>
        <br/>
        <br/>
        <tr>
            <td>内容</td>
            <td>
                <textarea id="mul_input" name="content" style="width:700px;height:200px;display: block;">

                </textarea>

            </td>

        </tr>
        <br>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"></td>
        </tr>
        <br/>

        <br/>
        <tr>
            <td>发布日期</td>
            <td>
                <input type="date" name="createTime">
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="发布">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
