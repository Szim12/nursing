<%--
  Created by IntelliJ IDEA.
  User: szm
  Date: 2024/6/5
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username}，欢迎您</h1>
<button type="button" value="新增" id="add">新增</button><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>姓名</th>
        <th>权限</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${users}" var="user" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${user.username}</td>
            <td>${user.fullname}</td>

            <c:if test="${user.role == 1}">
                <td>管理员</td>
            </c:if>
            <c:if test="${user.role == 2}">
                <td>用户</td>
            </c:if>

            <td>${user.phonenumber}</td>
            <td>${user.email}</td>

            <td><a href="/ms_war/selectByUsernameServlet?username=${user.username}">修改</a> <a href="#">删除</a> </td>
        </tr>
    </c:forEach>

</table>
<script>
    document.getElementById("add").onclick=function (){
        location.href="/ms_war/adduser.jsp";
    }
</script>
</body>

</html>
