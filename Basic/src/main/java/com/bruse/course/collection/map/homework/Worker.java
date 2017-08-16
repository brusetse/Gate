package com.bruse.course.collection.map.homework;

public class Worker implements Comparable<Worker> {

	private String name;
	private int age;
	private double salary;

	public Worker(String name, int age, double salary) {
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}

	@Override
	public int compareTo(Worker o) {
		if (this.age > o.age)
			return 1;
		else if (this.age < o.age)
			return -1;
		return 0;
	}

}
