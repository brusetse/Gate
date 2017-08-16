package com.bruse.course.collection.set;

import java.util.*;

public class HashSetDemo {

	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("张三",23,"男");
		Person p2 = new Person("李四",24,"女");
		Person p3 = new Person("王五",25,"男");
		Person p4 = new Person("赵六",23,"男");
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);

		System.out.println(set);
		System.out.println(set.size());
	}
}
