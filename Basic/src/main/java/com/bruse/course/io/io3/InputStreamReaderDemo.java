package com.bruse.course.io.io3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {
		//创建字节转化流
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("D:\\a.txt")));
		//读取字符
		int length = 0;
		while((length = isr.read()) != -1){
			System.out.println((char)length);
		}
		//关闭流
		isr.close();
	}
}