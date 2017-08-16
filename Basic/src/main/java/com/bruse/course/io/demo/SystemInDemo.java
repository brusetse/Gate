package com.bruse.course.io.demo;

import java.io.IOException;
import java.io.InputStream;

public class SystemInDemo {

	public static void main(String[] args) throws IOException {
		//创建标准输入流对象
		InputStream is = System.in;
		//用字节数组存储
		byte buf[] = new byte[1024];
		int length = is.read(buf);
		//将字节数组转化为字符串
		System.out.println(new String(buf,0,length));

		is.close();
	}
}