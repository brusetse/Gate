package com.bruse.net;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestRedirect extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String engine = request.getParameter("engine");
		String q = request.getParameter("q");
	    String urlbd = "https://www.baidu.com/s?wd=";
	    String url360 = "https://www.so.com/s?q=";
	    String urltb = "https://s.taobao.com/search?q=";
	    String str = null;
	    if (engine.equals("baidu")){
	    	str = urlbd + q;
	    }
	    if (engine.equals("360")){
	    	str = url360 + q;
	    }
	    if (engine.equals("taobao")){
	    	str = urltb + q;
	    }
	    response.sendRedirect(str);
	}

}
