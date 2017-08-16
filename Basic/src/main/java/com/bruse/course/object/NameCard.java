package com.bruse.course.object;

public class NameCard {
	String name;
	String unit;
	int telNum;

	NameCard(String a,String b,int c){
		name = a;
		unit = b;
		telNum = c;
	}

	public void print(){
		System.out.println("姓名为"+name+" 单位为"+unit+" 电话号码为"+telNum);
	}
}
