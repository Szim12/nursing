package com.szm.web;

import com.szm.pojo.User;
import com.szm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {

    UserService userService=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户名
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("useranme");
        //2.调用service查询
        User user=userService.selectByUsername(username);
        //3.相应标记
        boolean flag=false;
        if (user!=null){
            flag=true;
        }
        resp.getWriter().write(""+flag);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
