package com.bruse.course.collection.map.homework;

import java.util.HashSet;
import java.util.Iterator;

public class WorkerSetDemo {

	public static void main(String[] args) {
		HashSet<Worker> set = new HashSet<Worker>();
		// 创建Worker类对象
		Worker w1 = new Worker("zhang3", 47, 3200);
		Worker w2 = new Worker("li4", 37, 3800);
		Worker w3 = new Worker("wang5", 56, 4200);
		//添加元素
		set.add(w1);
		set.add(w2);
		set.add(w3);
		//遍历输出
		for (Iterator<Worker> iterator = set.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}