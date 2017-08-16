package com.bruse.course.io.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputStreamDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("a.txt")));

		Person p1 = new Person("张三", 23);
		Person p2 = new Person("李四", 34);
		Person p3 = new Person("王五", 45);
		//用集合存放对象
		ArrayList<Person> arrayList = new ArrayList<Person>();
		arrayList.add(p1);
		arrayList.add(p2);
		arrayList.add(p3);
		//写入集合对象
		oos.writeObject(arrayList);

		oos.close();
	}
}