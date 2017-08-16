package com.bruse.course.collection.set;

import java.util.*;

public class TreeSetDemo2 {
	//treeset在存储自定义对象时必须实现comparable接口,并重写compareTo方法
	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>(new TreeSetCompare());
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

class TreeSetCompare implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		if(o1.getAge() - o2.getAge() > 0){
			return 1;
		}else if(o1.getAge() - o2.getAge() < 0){
			return -1;
		}
		return o1.getName().compareTo(o2.getName());
	}

}
