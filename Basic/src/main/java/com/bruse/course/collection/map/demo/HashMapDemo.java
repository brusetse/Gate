package com.bruse.course.collection.map.demo;

import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		// hashMap的键值是可以为空，键只能有一个为空，值可以任意为空
		HashMap<String, String> map = new HashMap<String, String>();
		// 添加元素
		map.put("001", "zhang3");
		map.put("002", "li4");
		map.put("003", "wang5");
		map.put("004", "zhao6");
		// 判断是否包含指定的键
		System.out.println(map.containsKey("001"));
		// 判断是否包含指定的值
		System.out.println(map.containsValue("zhang3"));
		// 返回指定键映射的值
		System.out.println(map.get("003"));
		// 判断是否包含映射关系
		System.out.println(map.isEmpty());
		// 移除对应键的映射关系
		// map.remove("001");
		// 返回此映射中包含的键的 Set 视图。
		Set<String> set = map.keySet();
		// 遍历获取键
		for (String string : set) {
			System.out.println(string);
		}
		// 返回此映射中包含的值的 Collection 视图。
		Collection<String> collection = map.values();
		// 遍历获取值
		for (String string : collection) {
			System.out.println(string);
		}
		// 遍历获取键值对
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string + "----" + map.get(string));
		}
		// 遍历获取指定映射类型的键值对
		Set<Map.Entry<String, String>> set1 = map.entrySet();
		for (Map.Entry<String, String> entry : set1) {
			System.out.println(entry);
		}
		// System.out.println(collection);
	}
}
