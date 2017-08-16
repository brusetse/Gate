package com.bruse.course.poly.poly5;

public class Spyman {
	private String skill1 = "呼叫跑车";
	private String skill2 = "丟蝙蝠飞镖";
	private String skill3 = "打小丑";
	//	public void cast(String a){
//		System.out.println(a);
//	}
//	public void getNum(int a){
//		
//	}
	public void cast(int a){
		switch(a){
			case 1:System.out.println(skill1);
				break;
			case 2:System.out.println(skill2);
				break;
			case 3:System.out.println(skill3);
				break;
			default:break;
		}
	}
}
