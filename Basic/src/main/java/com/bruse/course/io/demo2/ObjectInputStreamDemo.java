package com.bruse.course.io.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputStreamDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//建立对象输入流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("a.txt")));
		//集合存储对象
		ArrayList<Person> arrayList = (ArrayList<Person>) ois.readObject();
		//遍历打印输出
		for (Person person : arrayList) {
			System.out.println(person);
		}

		ois.close();
	}
}