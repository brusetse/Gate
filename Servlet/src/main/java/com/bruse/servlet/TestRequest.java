package com.bruse.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestRequest extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getMethod();
        String requestURI = request.getRequestURI();//端口到？之间
        String queryString = request.getQueryString();
        String scheme = request.getScheme();
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();//?之前的内容
        String header = request.getHeader("User-Agent");
        String remoteAddr = request.getRemoteAddr();
        String localAddr = request.getLocalAddr();
        int localPort = request.getLocalPort();
        String parameter = request.getParameter("name");
        String parameter2 = request.getParameter("age");
        String parameter3 = request.getParameter("favs");
        String[] parameterValues = request.getParameterValues("favs");

        System.out.println(remoteAddr);
        System.out.println("TestRequest.doPost()");
    }
}
