package com.bruse.course.collection.map.demo2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		// 增加元素
		map.put("001", "red");
		map.put("002", "yellow");
		map.put("003", "blue");
		// 返回大于等于给定键的最小键；如果不存在这样的键，则返回 null
		System.out.println(map.ceilingKey("001"));
		// 返回严格大于给定键的最小键；如果不存在这样的键，则返回 null
		System.out.println(map.higherKey("001"));
		// 返回小于等于给定键的最大键；如果不存在这样的键，则返回 null
		System.out.println(map.floorKey("003"));
		// 返回严格小于给定键的最大键；如果不存在这样的键，则返回 null
		System.out.println(map.lowerKey("003"));
		// 返回此映射中当前第一个（最低）键
		System.out.println(map.firstKey());
		// 返回映射中当前最后一个（最高）键
		System.out.println(map.lastKey());
		// 返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。
		System.out.println(map.subMap("001", "002"));
		// 返回一个与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null
		System.out.println(map.firstEntry());
		// 返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回 null
		System.out.println(map.lastEntry());
		// 遍历获取键
		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(string);
		}
		// 遍历获取值
		Collection<String> collection = map.values();
		for (String string : collection) {
			System.out.println(string);
		}
		//遍历获取键值对
		for (String string : set) {
			System.out.println(string+" ---- "+map.get(string));
		}
		//遍历返回键值对，使用Map.entry
		Set<Map.Entry<String,String>> entry = map.entrySet();
		for (Map.Entry<String, String> entry2 : entry) {
			System.out.println(entry2);
		}
	}
}
