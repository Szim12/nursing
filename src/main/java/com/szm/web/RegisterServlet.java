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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;


@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户数据
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String fullname=req.getParameter("fullname");
        String password=req.getParameter("password");
        int role=2;
        String phonenumber=req.getParameter("phonenumber");
        String email=req.getParameter("email");

        //2.封装用户对象
        User user=new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPassword(password);
        user.setRole(role);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);

//      System.out.println(username);
//      System.out.println(password);
//      System.out.println(fullname);
//      System.out.println(role);
//      System.out.println(phonenumber);
//      System.out.println(email);
//      System.out.println(user);

        //获取用户输入的验证码
        String checkcode=req.getParameter("checkcode");
        //获取程序生成的验证码
        HttpSession session=req.getSession();
        String checkcodegen=(String)session.getAttribute("checkCodeGen");


        //比对验证码
        if (!checkcodegen.equals(checkcode)){
            //不允许注册
            req.setAttribute("register_msg","验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }

        boolean flag=userService.register(user);
        String register_msg,url;
        if(flag){
            //跳转登陆页面
            register_msg="注册成功，请登录";
            url="/login.jsp";
        }else{
            //注册失败，跳转到注册页面
            register_msg="注册失败，用户名已存在";
            url="/register.jsp";
        }
        req.setAttribute("register_msg",register_msg);
        req.getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
