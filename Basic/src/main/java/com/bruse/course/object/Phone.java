package com.bruse.course.object;

public class Phone {
	String color;
	double size;
	double cpuGhz;
	Phone(){
		color = "白色";
		size = 4.7;
		cpuGhz = 2.5;
	}

	public void call(int num){
		System.out.println("给"+num+"打电话");
	}

	public void about(){
		System.out.println("手机的颜色为"+color+",手机的尺寸为"+size+",手机的cpuGhz为"+cpuGhz);
	}
}
