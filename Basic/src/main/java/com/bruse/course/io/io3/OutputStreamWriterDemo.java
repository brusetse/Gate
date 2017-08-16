package com.bruse.course.io.io3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

	public static void main(String[] args) throws IOException {
		//创建字符转化流
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:\\a.txt")));
		//写入数据
		osw.write("商女不知亡国恨\r\n");
		osw.write("夜半钟声到客船\r\n");
		//关闭流
		osw.close();
	}
}