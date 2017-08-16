package com.bruse.course.io.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class OutputStreamDemo {

	public static void main(String[] args) throws IOException {
		//建立字节输出流管道
		OutputStream os = new FileOutputStream(new File("D:\\a.txt"),true);
		//往文件中写数据
		os.write(98);
		os.write('c');


		String string = "hellojava";
		byte buf[] = string.getBytes();
		os.write(buf);

		//关闭流
		os.close();
	}
}
