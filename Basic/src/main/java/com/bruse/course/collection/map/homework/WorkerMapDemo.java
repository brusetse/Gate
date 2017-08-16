package com.bruse.course.collection.map.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class WorkerMapDemo {

	public static void main(String[] args) {
		HashMap<String, Worker> map = new HashMap<String, Worker>();
		// 创建Worker类对象
		Worker w1 = new Worker("zhang3", 47, 3200);
		Worker w2 = new Worker("li4", 37, 3800);
		Worker w3 = new Worker("wang5", 56, 4200);
		// 添加元素
		map.put(w1.getName(), w1);
		map.put(w2.getName(), w2);
		map.put(w3.getName(), w3);
		// 遍历获取键
		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(string);
		}
		// 遍历获取值
		Collection<Worker> collection = map.values();
		for (Worker worker : collection) {
			System.out.println(worker);
		}
		// 遍历获取键值对
		for (String string : set) {
			System.out.println(string + " ---- " + map.get(string));
		}
		// 遍历返回键值对，使用Map.entry
		Set<Map.Entry<String, Worker>> set2 = map.entrySet();
		for (Map.Entry<String, Worker> entry : set2) {
			System.out.println(entry);
		}
	}
}
