package com.bruse.course.io.demo2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		//建立数据输入流
		DataInputStream dis = new DataInputStream(new FileInputStream(new File("a.txt")));

		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());

		dis.close();
	}
}