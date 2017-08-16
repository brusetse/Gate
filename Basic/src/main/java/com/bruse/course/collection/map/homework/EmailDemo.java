package com.bruse.course.collection.map.homework;

import java.util.HashMap;
import java.util.Set;

public class EmailDemo {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		// 添加元素
		map.put("sohu.com", "aa");
		map.put("163.com", "bb");
		map.put("sina.com", "cc");

		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(map.get(string) + "@" + string);
		}
	}
}

