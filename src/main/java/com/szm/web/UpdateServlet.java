package com.szm.web;

import com.szm.mapper.UserMapper;
import com.szm.pojo.User;
import com.szm.service.UserService;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        //1.接收表单提交的数据，封装为user对象
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String phonenumber = req.getParameter("phonenumber");
        String email = req.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);

        userService.update(user);

        req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
