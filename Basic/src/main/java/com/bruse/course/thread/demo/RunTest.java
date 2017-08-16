package com.bruse.course.thread.demo;

public class RunTest {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread th = new Thread(mr);
		th.start();
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(Thread.currentThread().getName()+"--------"+i);
		}
	}
}
