package com.bruse.course.object;

public class Point {
	int x,y,z;
	Point(int a,int b,int c){
		x = a;
		y = b;
		z = c;
	}
	
	public void move(int a,int b,int c){
		x += a;
		y += b;
		z += c;
	}
	
	public void print(){
		System.out.println("x="+x+" y="+y+" z="+z);
	}
}
