package com.bruse.course.collection.list;

import java.util.*;


public class Demo {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		//添加元素
		list.add("java");
		//添加指定未知的元素
		list.add(0, "mysql");
		//添加到开头
		list.addFirst("html");
		//添加到尾部
		list.addLast("jsp");
		System.out.println(list);
		System.out.println(list.element());//获取第一个元素
		System.out.println(list.get(1));//获取指定位置元素
		System.out.println(list.getFirst());//获取开头元素
		System.out.println(list.getLast());//获取尾部元素
		list.offer("servlet");//将指定元素添加到尾部
		System.out.println(list.peek());//获取头元素
		System.out.println(list.peekFirst());//获取第一个元素，若为空，返回null
		System.out.println(list.peekLast());//获取尾部元素，若为空，返回null
		list.poll();//移除开头元素
		list.pollFirst();//移除开头元素，若为空，返回null
		list.pollLast();//移除尾部元素，若为空，返回null
		System.out.println(list.pop());//弹出一个元素
		list.push("html");//推入一个元素
		list.remove();//移除头元素
		list.add("java");
		list.add("html");
		list.removeFirst();//移除头元素
		list.removeLast();//移除尾元素
		list.add("java");
		list.add("html");
		list.remove(0);//移除指定位置的元素
		list.remove("html");//移除指定内容的元素
		list.set(0, "html");//更改指定位置的元素
		System.out.println(list);
		System.out.println(list.size());
		list.add("java");
		list.add("jsp");
		System.out.println(list);
		//iterator迭代器
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		//listIterator迭代器，在遍历的同时进行添加操作
		for (ListIterator<String> lt = list.listIterator(); lt.hasNext();) {
			String string = (String) lt.next();
			if(string.equals("java"))
				lt.add("servlet");
			System.out.println(string);
		}
		System.out.println(list);
	}
}
