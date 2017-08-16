package com.bruse.course.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(10000);
		Socket client = ss.accept();

		InputStream is = client.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		User u = (User) ois.readObject();
		OutputStream os = client.getOutputStream();
		client.shutdownInput();

		if("zhangsan".equals(u.getId()) && "1234".equals(u.getPwd())){
			os.write("登录成功".getBytes());
		}else{
			os.write("用户名或密码错误，登录失败".getBytes());
		}
		client.shutdownOutput();

		os.close();
		ois.close();
		is.close();
		client.close();
		ss.close();
	}
}
