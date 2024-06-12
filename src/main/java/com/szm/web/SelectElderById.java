package com.szm.web;

import com.alibaba.fastjson.JSON;
import com.szm.pojo.Elder;
import com.szm.service.ElderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectElderById")
public class SelectElderById extends HttpServlet {
    private ElderService service = new ElderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Elder elder = service.selectElderById(Integer.parseInt(req.getParameter("id")));
        //2.把数据转为json
        String jsonString= JSON.toJSONString(elder);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
