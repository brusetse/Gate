package com.bruse.course.object;

public class Person {
	String name;
	int age;
	char sex;
	String food;
	String fun;
	String drinking;
	public void eat(){
		System.out.println(name+"吃"+food+"撑死了");
	}
	public void drink(){
		System.out.println(name+"喝"+drinking+"被毒死了");
	}
	public void play(){
		System.out.println(name+"玩"+fun+"猝死了");
	}
}
