package com.szm.web;


import com.szm.mapper.UserMapper;
import com.szm.pojo.User;
import com.szm.service.UserService;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户名和密码
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //获取复选框数据
        String remember=req.getParameter("remember");

        User user=userService.login(username,password);

        //获取对应的字符输出流，并设置content type
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        //3.判断user是否为null
        if(user!=null){

            //判断用户是否勾选记住我
            if ("1".equals(remember)){
                //勾选了，发送cookie
                //1.创建cookie对象
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);
                //2.发送cookie
                c_username.setMaxAge(60*60*24*7);//7天
                c_password.setMaxAge(60*60*24*7);
            }

            //将登陆成功后的对象存储在session中
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            //登录成功，跳转页面
            String contextPath = getServletContext().getContextPath();
            resp.sendRedirect(contextPath+"/selectAllServlet");
        }else{
            //登录失败
            //存储登录错误信息
            req.setAttribute("login_msg","用户名或密码错误");
            //跳转到登陆页面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
