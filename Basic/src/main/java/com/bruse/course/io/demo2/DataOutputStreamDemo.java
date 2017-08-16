package com.bruse.course.io.demo2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		//创建数据输出流
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("a.txt")));

		dos.writeBoolean(false);
		dos.writeInt(3);
		dos.writeChar('a');

		dos.close();
	}
}
