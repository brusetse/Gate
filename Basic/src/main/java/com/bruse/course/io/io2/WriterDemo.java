package com.bruse.course.io.io2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter(new File("D:\\a.txt"),true);
		//写入字符串
		writer.write("床前明月光\r\n");
		writer.write("疑似地上霜\r\n");
		writer.write("举头望明月\r\n");
		writer.write("低头思故乡\r\n");
		//写入字符数组
		char ch[] = {'为','何'};
		writer.write(ch,0,ch.length);
		//刷新该流缓冲
		writer.flush();
		//关闭流
		writer.close();
	}
}
