package com.bruse.course.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",10000);
		User u = getUser();
		OutputStream os = client.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(u);
		client.shutdownOutput();

		InputStream is = client.getInputStream();
		byte buf[] = new byte[1024];
		int length = is.read(buf);
		System.out.println(new String(buf,0,length));
		client.shutdownInput();

		is.close();
		oos.close();
		os.close();
		client.close();

	}

	public static User getUser(){
		User u = new User();
		System.out.println("请输入用户名：");
		Scanner s = new Scanner(System.in);
		u.setId(s.next());
		System.out.println("请输入密码：");
		u.setPwd(s.next());
		s.close();
		return u;
	}
}