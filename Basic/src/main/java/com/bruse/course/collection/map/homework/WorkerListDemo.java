package com.bruse.course.collection.map.homework;

import java.util.ArrayList;
import java.util.Collections;

public class WorkerListDemo {

	public static void main(String[] args) {
		ArrayList<Worker> list = new ArrayList<Worker>();
		// 创建Worker类对象
		Worker w1 = new Worker("zhang3", 47, 3200);
		Worker w2 = new Worker("li4", 37, 3800);
		Worker w3 = new Worker("wang5", 56, 4200);
		// 添加元素
		list.add(w1);
		list.add(w2);
		list.add(w3);
		//使用Collections工具类对list进行排序
		Collections.sort(list);
		System.out.println(list);
	}
}
