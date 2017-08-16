package com.bruse.course.io.io4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		//建立输入缓冲流
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\a.txt")));
		//存放字符串的容器
		StringBuilder stringBuilder = new StringBuilder();
		String string = null;
		//存取数据
		while((string = br.readLine())!=null){
			stringBuilder.append(string);
		}

		System.out.println(stringBuilder.toString());

		br.close();
	}
}