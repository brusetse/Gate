package com.bruse.course.io.io4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		//为什么这样写不行呢？
		//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\a.txt")),true);
		// FileWriter 写入文件中文乱码 参考http://blog.csdn.net/cai7095576/article/details/41250019
		FileWriter fw = new FileWriter(new File("D:\\a.txt"),true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("小楼昨夜又东风");
		bw.newLine();
		bw.write("故国不堪回首月明中");

		bw.flush();
		bw.close();
	}
}