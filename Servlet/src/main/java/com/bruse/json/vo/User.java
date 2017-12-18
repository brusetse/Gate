package com.bruse.json.vo;

import java.util.List;
import java.util.Map;

public class User {

	private String name;
	private int age;
	private Map city; 
	private List f;
	public List getF() {
		return f;
	}
	public void setF(List f) {
		this.f = f;
	}
	public Map getCity() {
		return city;
	}
	public void setCity(Map city) {
		this.city = city;
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
}
