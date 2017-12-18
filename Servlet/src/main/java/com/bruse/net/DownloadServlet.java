package com.bruse.net;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {

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

		String filename = request.getParameter("filename");
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename="+new String("01servlet和http协议.pdf".getBytes("gbk"),"iso8859-1"));
		ServletOutputStream outputStream = response.getOutputStream();
		InputStream is = this.getServletContext().getResourceAsStream("/file/01servlet和http协议.pdf");
		byte[] buf = new byte[1024];
		int a = 0;
		while((a = is.read(buf))!=-1){
			outputStream.write(buf, 0, a);
		}
		outputStream.flush();
		outputStream.close();
		is.close();
	}

}
