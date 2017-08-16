package com.bruse.course.collection.set.dogDemo;

public class Dog {

	private String name;
	private int love;
	
	public Dog(){
		
	}
	
	public Dog(String name, int love) {
		super();
		this.name = name;
		this.love = love;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", love=" + love + "]";
	}
	
	
}
