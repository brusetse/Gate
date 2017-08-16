package com.bruse.course.task.hw0821.homework6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class Test {

	/**
	 * 事先在当前目录下准备好一个test.txt 的文本文件，要求该文本文件是使用GBK 编码的多行文本文件。
	 * 用字节流读入这个文本文件，然后按照行的顺序，以UTF-8 的编码方式，写到test2.txt 文件中
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		try {
			write(read());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String read() throws IOException{
		InputStream is = new FileInputStream("test.txt");
		byte buf[] = new byte[1024];
		int length = is.read(buf);
		String string = new String(buf,0,length);
		is.close();
		return string;
	}

	public static void write(String string) throws IOException{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("test2.txt"),"utf-8");
		osw.write(string, 0, string.length());
		osw.close();
	}
}