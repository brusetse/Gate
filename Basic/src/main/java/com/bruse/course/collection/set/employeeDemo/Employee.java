package com.bruse.course.collection.set.employeeDemo;

public class Employee {
	
	private int num;
	private String name;
	private int age;
	
	public Employee(){
		
	}
	
	public Employee(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		return "Employee [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
