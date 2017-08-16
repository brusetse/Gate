package com.bruse.course.collection.col2;

import java.util.*;

/**
 * List 接口
 * 增 删 改 查
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		//增
		li.add("123");
		li.add("张三");
		li.add("java");
		sop(li);
		//删
		sop(li.remove(0));
		sop(li.remove("张三"));
		li.add(0, "李四");
		sop(li);
//		li.clear();
//		sop(li);
		sop(li.contains("李四"));
		//改
		li.set(0, "html");
		sop(li.get(1));
		sop(li);
		li.add("mysql");
		//for循环 iterator遍历 外国人
		for (Iterator<String> iterator = li.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();//返回游标当前位置的元素并将游标移动到下一个位置
			sop(object);
		}
		//加强for循环
		for (Object object : li) {
			sop(object);
		}
		//for循环 iterator遍历
		Iterator<String> iterator = li.iterator();
		while(iterator.hasNext()){
			sop(iterator.next());
		}
	}

	public static void sop(Object obj){
		System.out.println(obj);
	}
}