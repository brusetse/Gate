package com.bruse.course.collection.map.demo2;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo2 {

	public static void main(String[] args) {
		TreeMap<Person,String> map = new TreeMap<Person,String>(new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				if(o1.getAge()>o2.getAge())
					return 1;
				else if(o1.getAge()<o2.getAge())
					return -1;
				return 0;
			}
		});
		//创建Person类对象
		Person p1 = new Person("zhang3",39);
		Person p2 = new Person("li4",26);
		Person p3 = new Person("wang5",53);
		//添加元素
		map.put(p1,"001");
		map.put(p2,"002");
		map.put(p3,"003");

		System.out.println(map);
	}
}

class MyCompare implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		if(o1.getAge()>o2.getAge())
			return 1;
		else if(o1.getAge()<o2.getAge())
			return -1;
		return 0;
	}

}