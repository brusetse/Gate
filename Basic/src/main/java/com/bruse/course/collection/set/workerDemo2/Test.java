package com.bruse.course.collection.set.workerDemo2;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		TreeSet<Worker> li = new TreeSet<Worker>();
		//添加工人信息
		Worker w1 = new Worker("zhang3",18,1500);
		Worker w2 = new Worker("li4",18,1500);
		Worker w3 = new Worker("wang5",18,1600);
		Worker w4 = new Worker("zhao6",17,2000);
		li.add(w1);
		li.add(w2);
		li.add(w3);
		li.add(w4);
		//迭代遍历输出
		for (Iterator<Worker> iterator = li.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}
