package com.bruse.course.extend;


public class Car {
	int height;
	int wheel;
	String color;
	public void setCar(int a,int b,String c){
		height = a;
		wheel = b;
		color = c;
	}
	public void print(){
		System.out.println("车重为"+height+" 车轮个数为"+wheel+" 颜色为"+color);
	}
}

class LittleCar extends Car{
	int vistors;
	LittleCar(int a){
		vistors = a;
	}
	public void print(){
		super.print();
		System.out.println("载客数为"+vistors);
	}
}

class Truck extends Car{
	int carry;
	Truck(int a){
		carry = a;
	}
	public void print(){
		super.print();
		System.out.println("载货量为"+carry);
	}
}








