package com.bruse.course.collection.set.treeSetDemo;

import java.util.*;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>(new TreeSetCompare());
		//添加Person对象元素
		Person p1 = new Person("zhang3",18,3000);
		Person p2 = new Person("li4",25,3500);
		Person p3 = new Person("wang5",22,3200);
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);

		System.out.println(ts);
	}
}
//内部比较器
class TreeSetCompare implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		if(o1.getName().length() - o2.getName().length() > 0)
			return 1;
		else if(o1.getName().length() - o2.getName().length() < 0)
			return -1;
		return o1.getName().compareTo(o2.getName());
	}

}

