package com.bruse.course.collection.set;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java");//添加操作
		set.add("html");
		set.add("mysql");
//		set.remove("java");//删除操作
		System.out.println(set);
		System.out.println(set.size());
//		set.clear();
//		System.out.println(set.isEmpty());
		//是否包括指定元素
		System.out.println(set.contains("java"));

		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}