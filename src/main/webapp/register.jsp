<%--
  Created by IntelliJ IDEA.
  User: 21807
  Date: 2024/6/6
  Time: 15:30
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
        .err_msg{
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
    <h2>注册</h2>
    <form action="/ms_war/registerServlet" id="form" method="post">
        <span id="username_err" class="err_msg">${register_msg}</span>
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" placeholder="请输入您的用户名">
        </div>
        <div class="form-group">
            <label for="username">姓名:</label>
            <input type="text" id="fullname" name="fullname" placeholder="请输入您的姓名">
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" placeholder="请输入您的密码">
        </div>
        <div class="form-group">
            <label for="phonenumber">电话:</label>
            <input type="text" id="phonenumber" name="phonenumber" placeholder="请输入您的电话">
        </div>
        <div class="form-group">
            <label for="email">邮箱:</label>
            <input type="text" id="email" name="email" placeholder="请输入您的邮箱">
        </div>
        <div class="form-group">
            <label for="checkcode">验证码:</label>
            <input type="text" id="checkcode" name="checkcode" placeholder="请输入验证码" style="width: 45%">
            <img src="/ms_war/checkCodeServlet" id="checkcodeImg">
            <a href="#" id="changeImg">看不清？</a>
        </div>
        <button class="btn" type="submit">注册</button>
        <button class="btn" type="reset">重置</button>
        已有账户？<a href="login.jsp">点击登录</a>
    </form>
</div>
</body>
<script>
    document.getElementById("changeImg").onclick=function (){
        document.getElementById("checkcodeImg").src="/ms_war/checkCodeServlet?"+new Date().getMilliseconds();
    }
    document.getElementById("checkcodeImg").onclick=function () {
        document.getElementById("checkcodeImg").src="/ms_war/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>
</html>
