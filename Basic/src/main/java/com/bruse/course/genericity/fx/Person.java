package com.bruse.course.genericity.fx;

public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Person(String name){
		this.name = name;
	}
	//重写toString方法，本来应该返回该对象的字符串表示

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}


}
