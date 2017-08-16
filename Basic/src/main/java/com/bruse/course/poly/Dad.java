package com.bruse.course.poly;

public class Dad {
	String haircolor;
	String eye;
	private int SFQ;
	private void smoke(){
		System.out.println("饭后一支烟，快活似神仙");
		SFQ -= 10;
	}
	private void drink2(){
		System.out.println("酒逢知己千杯少");
		SFQ -= 100;
	}
}

class Son extends Dad{
	Son(String a,String b){
		haircolor = a;
		eye = b;
	}
	public void print(){
		System.out.println("儿子的头发是"+haircolor);
		System.out.println("眼睛是"+eye);
	}
}