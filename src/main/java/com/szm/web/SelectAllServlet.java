package com.szm.web;

import com.alibaba.fastjson.JSON;
import com.szm.pojo.User;
import com.szm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private UserService service=new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        List<User> users =service.selectAll();

        //2.把数据转为json
        String jsonString=JSON.toJSONString(users);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

        /*//2.存入request域中
        req.setAttribute("users",users);

        //3.转发到user.jsp
        req.getRequestDispatcher("/user.jsp").forward(req,resp);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
