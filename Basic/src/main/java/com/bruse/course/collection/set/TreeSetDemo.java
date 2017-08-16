package com.bruse.course.collection.set;

import java.util.*;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("apple");
		ts.add("pear");
		ts.add("banana");
		ts.add("orange");
		System.out.println(ts.first());//返回最小元素
		System.out.println(ts.ceiling("banana"));//返回大于等于该元素的最小元素，如果没有，返回null
		System.out.println(ts.higher("banana"));//返回严格大于该元素的最小元素，如果没有，返回null
		System.out.println(ts.floor("banana"));//返回小于等于该元素的最大元素，如果没有，返回null
		System.out.println(ts.lower("banana"));//返回严格小于该元素的最大元素，如果没有，返回null

		//ts.remove("apple");//删除指定元素
		System.out.println(ts.pollFirst());//获取并移除一个最小元素，如果没有，返回null
		System.out.println(ts.pollLast());//获取并移除一个最大元素，如果没有，返回null
		System.out.println(ts);
	}
}
