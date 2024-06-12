package com.szm.web;

import com.alibaba.fastjson.JSON;
import com.szm.pojo.Elder;
import com.szm.pojo.User;
import com.szm.service.ElderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllElder")
public class SelectAllElder extends HttpServlet {

    private ElderService service=new ElderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        List<Elder> elders =service.selectAllElder();

        //2.把数据转为json
        String jsonString= JSON.toJSONString(elders);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
