package com.bruse.course.collection.map.demo;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		// 添加元素
		map.put("001", "zhang3");
		map.put("002", "li4");
		map.put("003", "wang5");
		map.put("004", "zhao6");
		// 如果此映射将一个或多个键映射到指定值，则返回 true
		System.out.println(map.containsValue("li4"));
		// 返回此映射到指定键的值
		System.out.println(map.get("001"));
		// 从该映射中移除所有映射关系
		// map.clear();
	}
}
