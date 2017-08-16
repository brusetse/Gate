package com.bruse.course.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class PicUpload {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("192.168.0.44",10000);

		FileInputStream fis = new FileInputStream(new File("a.jpg"));
		OutputStream os = client.getOutputStream();

		int length = 0;
		while((length = fis.read())!=-1){
			os.write(length);
		}
		client.shutdownOutput();

		os.close();
		fis.close();
		client.close();
	}
}