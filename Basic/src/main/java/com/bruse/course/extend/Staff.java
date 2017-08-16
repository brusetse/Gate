package com.bruse.course.extend;

public class Staff {
	int num;
	String name;
	double salary;
	public void setStaff(int a,String b,double c){
		num = a;
		name = b;
		salary = c;
	}
	public void print(){
		System.out.println("编号为"+num+" 姓名为"+name+" 工资为"+salary);
	}
}

class Manager extends Staff{
	double salary = 8000;
//	public void print(){
//		System.out.println("每月工资是8000");
//	}
}

class Technical extends Staff{
	int hours;
	int days;
	double salary;
	Technical(int a,int b){
		hours = a;
		days = b;
		salary = 100*hours*days;
	}
//	public void print(){
//		System.out.println("每月工资是"+100*hours*days);
//	}
}

class Sales extends Staff{
	double amounts;
	double salary;
	Sales(int a) {
		amounts = a;
		salary = amounts*0.04;
	}
//	public void print(){
//		System.out.println("每月工资是"+amounts*0.04);
//	}
}

class PM extends Staff{
	double base = 5000;
	double achivement;
	double salary;
	PM(int a){
		achivement = a;
		salary = base+achivement*0.05;
	}
//	public void print(){
//		System.out.println("每月工资是"+(base+achivement*0.05));
//	}
}