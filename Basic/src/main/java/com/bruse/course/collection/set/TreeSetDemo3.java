package com.bruse.course.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo3 {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>(new Comparator<Person>(){
			public int compare(Person o1, Person o2) {
				if(o1.getAge() - o2.getAge() > 0)
					return 1;
				else if(o1.getAge() - o2.getAge() < 0)
					return -1;
				return o1.getName().compareTo(o2.getName());
			}
		});
		Person p1 = new Person("张三",23,"男");
		Person p2 = new Person("李四",24,"女");
		Person p3 = new Person("王五",25,"男");
		Person p4 = new Person("赵六",23,"男");
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println(ts);
	}
}