package com.bruse.course.poly.poly1;

public class Parents extends Person{
	public void sayGoodBye(){
		System.out.println("Parents say goodbye");
		new Kid().sayGoodBye();
	}
}

class Kid extends Person{
	public void sayGoodBye(){
		System.out.println("The kid say goodbye");
	}
}