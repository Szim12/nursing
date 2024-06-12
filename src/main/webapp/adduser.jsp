<%--
  Created by IntelliJ IDEA.
  User: 21807
  Date: 2024/6/5
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/ms_war/addServlet" method="post">
    用户名：<input name="username"><br>
    姓名：<input name="fullname"><br>
    权限：<input name="role"><br>
    电话：<input name="phonenumber"><br>
    邮箱：<input name="email"><br>
    <button type="submit">提交</button>
    <button type="reset">重置</button>
</form>

</body>
</html>
