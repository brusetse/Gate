package com.bruse.course.poly;

public class Animal {
	private int age;
	public void setAge(int a){
		age = a;
	}
	public void intro(){
		System.out.println("我今年"+age+"岁了");
	}
}

class Fish extends Animal{
	private int weight;
	Fish(int a,int b){
		setAge(a);
		weight = b;
	}
	public void intro(){
		System.out.println("我是一只"+weight+"斤重的鱼");
		super.intro();
	}
	public void swim(){
		System.out.println("我游啊游");
	}
}

class Bird extends Animal{
	private String color;
	Bird(int a,String b){
		setAge(a);
		color = b;
	}
	public void intro(){
		System.out.println("我是一只"+color+"的鸟");
		super.intro();
	}
	public void fly(){
		System.out.println("我飞啊飞");
	}
}


