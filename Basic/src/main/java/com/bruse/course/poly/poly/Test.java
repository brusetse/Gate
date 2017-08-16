package com.bruse.course.poly.poly;

public class Test {
	public static void main(String[] args) {
		Student a = new goodStudent();
		a.study();
	}
}

class Student{
	public void study(){

	}
}

class goodStudent extends Student{
	public void study(){
		System.out.println("好好学习");
	}
}

