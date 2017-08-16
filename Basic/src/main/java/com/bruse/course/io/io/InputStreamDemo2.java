package com.bruse.course.io.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo2 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(new File("D:\\a.txt"));

		//创建缓冲区
		byte buf[] = new byte[1024];
		//将数据存入缓冲区,返回的是字节总数
		int changdu = is.read(buf);
		String string =new String(buf,0,changdu);

		System.out.println(string);
		//关闭流
		is.close();
	}
}
