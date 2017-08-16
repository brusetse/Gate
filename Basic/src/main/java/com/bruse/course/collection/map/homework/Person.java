package com.bruse.course.collection.map.homework;

public class Person {

	private String name;
	private int age;
	private int weight;
	private String address;

	public Person() {
		super();
	}

	public Person(String name, int age, int weight, String address) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.address = address;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", address=" + address + "]";
	}

}
