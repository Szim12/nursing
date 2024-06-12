//package com.szm.web.filter;
//
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        //判断访问资源路径是否和登录注册相关
//        String[]urls={"/login.jsp","/loginServlet", "/register.jsp","/registerServlet","/checkCodeServlet"};
//        //获取当前访问资源路径
//        String url=request.getRequestURL().toString();
//        //循环判断
//        for (String u:urls){
//            if (url.contains(u)){
//                //找到了，放行
//                filterChain.doFilter(servletRequest,servletResponse);
//                return;
//            }
//        }
//
//        //1.判断session中是否有user
//        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");
//        //2.判断是否为null
//        if (user == null) {
//            //没有登录，拦截，跳转到登陆界面
//            //放行css资源和注册资源
//            request.setAttribute("login_msg","您尚未登录");
//            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
//        }else{
//            //登录过
//            filterChain.doFilter(request, servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
