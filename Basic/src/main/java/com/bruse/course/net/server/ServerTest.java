package com.bruse.course.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerTest {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		ServerSocket ss = new ServerSocket(10000);
		Socket client = ss.accept();
		
		while(true){
			InputStream is = client.getInputStream();
			byte buf[] = new byte[1024];
			int length = is.read(buf);
			String string = new String(buf,0,length);
			System.out.println(string);
//			client.shutdownInput();
			
			OutputStream os = client.getOutputStream();
			os.write(s.next().getBytes());
//			client.shutdownOutput();
		}
		
		
//		os.close();
//		is.close();
//		client.close();
//		ss.close();
		
	}
}
