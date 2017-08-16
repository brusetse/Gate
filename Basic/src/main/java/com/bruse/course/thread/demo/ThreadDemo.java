package com.bruse.course.thread.demo;

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-----------" + i);
		}
	}

}
