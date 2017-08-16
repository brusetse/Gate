package com.bruse.course.poly.poly3;

public class Dad {
	public void say(){
		System.out.println("Everyone should follow me!");
	}
	public void daughterSay(){
		System.out.println("Alice,it's your turn");
		new daughter().say();
	}
	public void dogSay(){
		System.out.println("Snoopy,it's your turn");
		new Dog().say();
	}
}
