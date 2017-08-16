package com.bruse.course.io.demo;

import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) {
		//创建字符打印流
		PrintWriter pw = new PrintWriter(System.out);

		pw.println(true);
		pw.println('a');
		pw.print(3);
		pw.print("恶俗是可耻的");

		pw.close();
	}
}