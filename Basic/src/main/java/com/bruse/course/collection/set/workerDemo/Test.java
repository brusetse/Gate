package com.bruse.course.collection.set.workerDemo;

import java.util.*;


public class Test {

	public static void main(String[] args) {
		ArrayList<Worker> li = new ArrayList<Worker>();
		//添加工人信息
		Worker w1 = new Worker("zhang3",18,3000);
		Worker w2 = new Worker("li4",25,3500);
		Worker w3 = new Worker("wang5",22,3200);
		li.add(w1);
		li.add(w2);
		li.add(w3);
		//在li4之前插入zhao6
		Worker w4 = new Worker("zhao6",24,3300);
		li.add(1, w4);
		//删除wang5的信息
		li.remove(3);
		//利用for 循环遍历，打印List 中所有工人的信息
		for (Iterator<Worker> iterator = li.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		//利用迭代遍历，对List 中所有的工人调用work 方法。
		for (Iterator<Worker> iterator = li.iterator(); iterator.hasNext();) {
			iterator.next().work();
		}
	}
}
