package com.bruse.course.thread.demo2;

public class TestAlive {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread thread = new Thread(mr);
		
		System.out.println(thread.isAlive());
		thread.start();
		System.out.println(thread.isAlive());
	}
}
