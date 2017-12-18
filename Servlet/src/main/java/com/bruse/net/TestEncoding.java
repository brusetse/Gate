package com.bruse.net;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestEncoding extends HttpServlet {

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
		//post方式提交的数据
		request.setCharacterEncoding("utf-8");
		String parameter = request.getParameter("uname");
		System.out.println(parameter);
		//通用方法
//		String str = new String(parameter.getBytes("iso-8859-1"),"utf-8");
//		System.out.println(str);
//		 get方式提交的数据
//		 在server.xml中元素<Connector>中增加属性：
//		 useBodyEncodingForURI=“true” ，则 上面对get方式提交的数据
//		 也有效
	}

}
