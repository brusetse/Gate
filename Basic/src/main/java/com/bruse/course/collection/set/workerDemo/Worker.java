package com.bruse.course.collection.set.workerDemo;

public class Worker {

	private String name;
	private int age;
	private int salary;
	
	public Worker() {
		super();
	}

	public Worker(String name, int age, int salary) {
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

	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
	public void work(){
		System.out.println(name+" work");
	}
}
