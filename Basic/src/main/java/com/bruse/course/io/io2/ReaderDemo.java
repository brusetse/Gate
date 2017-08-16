package com.bruse.course.io.io2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		//创建字符输入流管道
		Reader reader = new FileReader(new File("D:\\a.txt"));
		//读取字符
//		int length = 0;
//		while((length = reader.read())!=-1){
//			System.out.print((char)length);
//		}
		//用数组读取字符
		char ch[] = new char[1024];
		int changdu = reader.read(ch);
		String string = new String(ch,0,changdu);
		System.out.println(string);
		//关闭流
		reader.close();
	}
}
