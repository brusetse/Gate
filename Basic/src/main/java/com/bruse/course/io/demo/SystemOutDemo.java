package com.bruse.course.io.demo;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutDemo {

	public static void main(String[] args) throws IOException {
		//建立标准输出流
		OutputStream os = System.out;
		os.write("为什么".getBytes());

		os.close();
	}
}
