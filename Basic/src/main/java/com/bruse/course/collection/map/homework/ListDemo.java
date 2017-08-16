package com.bruse.course.collection.map.homework;

import java.util.ArrayList;

public class ListDemo {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		// 创建Person类对象
		Person p1 = new Person("张三", 18, 90, "北京");
		Person p2 = new Person("李四", 28, 50, "上海");
		// 添加元素
		list.add(p1);
		list.add(p2);
	}
}
