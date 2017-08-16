package com.bruse.course.collection.map.demo;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableDemo {

	public static void main(String[] args) {
		// hashTable的键和值都不能为空
		Hashtable<String, String> map = new Hashtable<String, String>();
		// 添加元素
		map.put("001", "zhang3");
		map.put("002", "li4");
		map.put("003", "wang5");
		map.put("004", "zhao6");
		// 是否存在与指定值关联的键
		System.out.println(map.contains("zhang3"));
		// 测试指定对象是否为此哈希表中的键
		System.out.println(map.containsKey("001"));
		// 如果此 Hashtable 将一个或多个键映射到此值，则返回 true
		System.out.println(map.containsValue("zhang3"));
		// 返回此哈希表中的值的枚举
		System.out.println(map.elements());
		// 返回指定键所映射到的值，如果此映射不包含此键的映射，则返回 null
		System.out.println(map.get("001"));
		// 按照 Map 接口的定义，返回此 Map 的哈希码值
		System.out.println(map.hashCode());
		// 测试此哈希表是否没有键映射到值
		System.out.println(map.isEmpty());
		// 从哈希表中移除该键及其相应的值
		map.remove("004");
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
		// 遍历获取指定映射类型的键值对
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		for (Map.Entry<String, String> entry : set2) {
			System.out.println(entry);
		}
	}
}
