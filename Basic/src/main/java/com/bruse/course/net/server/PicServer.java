package com.bruse.course.net.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10000);
		Socket client = ss.accept();
		
		InputStream is = client.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("b.jpg"));
		
		int length = 0;
		while((length = is.read())!=-1){
			fos.write(length);
		}
		client.shutdownInput();
		
		fos.close();
		is.close();
		client.close();
		ss.close();
	}
}
