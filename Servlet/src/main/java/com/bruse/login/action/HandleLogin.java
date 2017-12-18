package com.bruse.login.action;

import com.bruse.login.dao.impl.UserDaoImpl;
import com.bruse.login.po.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class HandleLogin extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.findUser(uname, pwd);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", user);
			response.sendRedirect("Success");
		}else{
			request.setAttribute("error", "账号密码有误！");
			request.setAttribute("uname", uname);
			request.setAttribute("pwd", pwd);
			request.getRequestDispatcher("LoginPage").forward(request, response);
		}
	}

}
