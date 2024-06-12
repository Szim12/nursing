<%--
  Created by IntelliJ IDEA.
  User: 21807
  Date: 2024/6/5
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改数据</title>
</head>
<body>
<form action="/ms_war/updateServlet" method="post">

    用户名：<input name="username" value="${user.username}" readonly><br>
    姓名：<input name="fullname" value="${user.fullname}"><br>
    权限：
    <c:if test="${user.role == 1}">
        <input name="role" value="管理员" disabled>
    </c:if>
    <c:if test="${user.role == 2}">
        <input name="role" value="用户" disabled>
    </c:if>
    <br>
    电话：<input name="phonenumber" value="${user.phonenumber}" ><br>
    邮箱：<input name="email" value="${user.email}"><br>
    <button type="submit">提交</button>
    <button type="reset">重置</button>
</form>
</body>
</html>
