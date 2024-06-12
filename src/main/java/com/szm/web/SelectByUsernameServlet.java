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

@WebServlet("/selectByUsernameServlet")
public class SelectByUsernameServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.selectByUsername(req.getParameter("username"));

        String jsonString= JSON.toJSONString(user);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
        /*req.setAttribute("user", user);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
