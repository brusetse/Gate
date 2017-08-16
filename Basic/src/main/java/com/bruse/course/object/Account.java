package com.bruse.course.object;

public class Account {
	int num;
	int key;
	double money;
	int year;

	Account(int a,int b,double c,int d){
		num = a;
		key = b;
		money = c;
		year = d;
	}

	public void getMoney(int a){
		money -= a;
	}

	public void print(){
		System.out.println("账户号码为"+num+" 账户密码为"+key+" 剩余金额为"+money+" 存款年限为"+year);
	}
}
