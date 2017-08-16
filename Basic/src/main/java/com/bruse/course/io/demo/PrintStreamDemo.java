package com.bruse.course.io.demo;

import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) {
		//创建字节打印流
		PrintStream ps = System.out;

		ps.println(true);
		ps.println('a');
		ps.println(0.1);
		ps.println(3);
		ps.print("为何");

		ps.close();
	}
}