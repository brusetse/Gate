package com.bruse.course.reflect;

public class Person {
	private String name;
	public static int age;
	protected String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Person.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	private void add(int a,int b){
		System.out.println("Person.add("+a+","+b+")="+(a+b));
	}
	
}
