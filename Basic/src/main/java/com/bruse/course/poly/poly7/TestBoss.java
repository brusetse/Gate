package com.bruse.course.poly.poly7;

public class TestBoss {
	public static void main(String[] args) {

		Boss chinese = new Chinese();
		chinese.eat();
		chinese.work();
		System.out.println("*************************");
		Boss america = new America();
		america.eat();
		america.work();
		System.out.println("*************************");

		Boss italy = new Italy();
		italy.eat();
		italy.work();


	}
}
