package com.bruse.course.extend;

public class Person {
	String name;
	int age;
	String gender;
	String address;
	
	public void setPerson(String a,int b,String c,String d){
		name = a;
		age = b;
		gender = c;
		address = d;
	}
	
	public void print(){
		System.out.println("name="+name+" age="+age+" gender="+gender+" address="+address);
	}
}

class StudentP extends Person{
	int studynum;
	int classp;
	String major;
	int score;
	
	StudentP(int a,int b,String c,int d){
		studynum = a;
		classp = b;
		major = c;
		score = d;
	}
	
	public void print(){
		System.out.println("studynum="+studynum+" classp="+classp+" major="+major+" score"+score);
		super.print();
	}
}

class Teacher extends Person{
	int worknum;
	String title;
	int salary;
	
	Teacher(int a,String b,int c){
		worknum = a;
		title = b;
		salary = c;
	}
	
	public void print(){
		System.out.println("worknum="+worknum+" title="+title+" salary="+salary);
		super.print();
	}
}


