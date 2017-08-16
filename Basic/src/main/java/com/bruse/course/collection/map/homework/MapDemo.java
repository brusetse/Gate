package com.bruse.course.collection.map.homework;

import java.util.HashMap;


public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Person> map = new HashMap<String, Person>();
		// 创建Person类对象
		Person p1 = new Person("张三", 18, 90, "北京");
		Person p2 = new Person("李四", 28, 50, "上海");
		// 添加元素
		map.put("001", p1);
		map.put("002", p2);
		// 取出李四
		System.out.println(map.get("002"));
	}
}
