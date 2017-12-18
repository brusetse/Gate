package com.bruse.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1)
            throws ServletException, IOException {
		// super.service(arg0, arg1);
        System.out.println("HelloServlet.service()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//		super.doGet(req, resp);
        System.out.println("TestServlet.doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//		super.doPost(req, resp);
        System.out.println("TestServlet.doPost()");
    }

    @Override
    public void destroy() {
//		super.destroy();
        System.out.println("TestServlet.destroy()");
    }

    @Override
    public void init() throws ServletException {
        // super.init();
        System.out.println("TestServlet.init()");
    }
}
