package com.bruse.course.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner s = new Scanner(System.in);
		Socket client = new Socket("localhost",10000);

		while(true){
			OutputStream os = client.getOutputStream();
			os.write(s.next().getBytes());

			InputStream is = client.getInputStream();
			byte buf[] = new byte[1024];
			int length = is.read(buf);
			System.out.println(new String(buf,0,length));
		}

		//client.close();
	}
}
