package com.bruse.course.extend;

public class MyClass{

//	public void print(String a,int b,int c){
//		System.out.println("name="+a+" age="+b+" height="+c);
//	}
	public void print(Student a,Student b,Student c,Student d,Student e){
		System.out.println("name="+a.name+" age="+a.age+" height="+a.height);
		System.out.println("name="+b.name+" age="+b.age+" height="+b.height);
		System.out.println("name="+c.name+" age="+c.age+" height="+c.height);
		System.out.println("name="+d.name+" age="+d.age+" height="+d.height);
		System.out.println("name="+e.name+" age="+e.age+" height="+e.height);
	}
}

class Student{
	String name;
	int age;
	int height;
	Student(String a,int b,int c){
		name = a;
		age = b;
		height = c;
	}
	public void print(){
		System.out.println("name="+name+" age="+age+" height="+height);
	}
}
