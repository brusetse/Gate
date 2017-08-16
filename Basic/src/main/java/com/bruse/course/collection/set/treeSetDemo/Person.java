package com.bruse.course.collection.set.treeSetDemo;

public class Person /*implements Comparable<Person>*/{

	private String name;
	private int age;
	private int salary;

	public Person(){

	}

	public Person(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	//外部比较器，重写compareTo方法
/*	@Override
	public int compareTo(Person o) {
		if(this.name.length() - o.name.length() > 0)
			return 1;
		else if(this.name.length() - o.name.length() < 0)
			return -1;
		return this.name.compareTo(o.name);
	}*/

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}


}
