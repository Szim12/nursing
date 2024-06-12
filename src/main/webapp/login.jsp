<%--
  Created by IntelliJ IDEA.
  User: 21807
  Date: 2024/6/6
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        #loginMsg{
            color: red;
            margin-bottom: 0;
            padding: 5px;
            font-size: small;
            font-family: 微软雅黑;
        }
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .btn {
            display: block;
            width: 25%;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            display:inline-block;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="/ms_war/loginServlet" id="form" method="post">
        <div id="loginMsg">${login_msg}${register_msg}</div>
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" value="${cookie.username.value}" id="username" name="username" placeholder="请输入您的用户名">
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" value="${cookie.password.value}" id="password" name="password" placeholder="请输入您的密码">
        </div>
        <p>记住我：<input type="checkbox" name="remember" id="remember" value="1"></p>
        <button class="btn" type="submit">登录</button>
        <button class="btn" type="reset">重置</button>
        还没有账户？<a href="register.jsp">点击注册</a>
    </form>
</div>
</body>
</html>
