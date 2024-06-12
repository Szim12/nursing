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

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收表单提交的数据，封装为user对象
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        int role = Integer.parseInt(req.getParameter("role"));
        String phonenumber = req.getParameter("phonenumber");
        String email = req.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setRole(role);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);

        User user1=userService.selectByUsername(username);

        //3.判断用户名是否存在，调用mapper
        if(user1!=null){
            //用户名存在，不可添加
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("用户名已存在");
        }else{
            //用户名不存在，可添加
            userService.insert(user);
            //3.转发到所有的servlet
            req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
