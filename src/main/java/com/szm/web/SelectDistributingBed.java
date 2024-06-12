package com.szm.web;

import com.alibaba.fastjson.JSON;
import com.szm.pojo.Bed;
import com.szm.service.BedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/SelectDistributingBed")
public class SelectDistributingBed extends HttpServlet {

    BedService bedService = new BedService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Bed>list=bedService.SelectDistributingBed();
        String jsonString= JSON.toJSONString(list);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
