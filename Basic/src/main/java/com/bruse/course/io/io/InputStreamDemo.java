package com.bruse.course.io.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\a.txt");
		//创建一个输入字节流对象，将源文件跟程序连接起来，起到管道的作用
		InputStream is = new FileInputStream(file);

//		int length = is.read();
//		while(length!=-1){
//			System.out.println((char)length);
//			length = is.read();
//		}

		int length = 0;
		while((length=is.read())!=-1){
			System.out.println((char)length);
		}

		is.close();
	}
}