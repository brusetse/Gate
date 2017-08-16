package com.bruse.course.thread.ticket;

public class Test {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread thread1 = new Thread(mr,"窗口A");
		Thread thread2 = new Thread(mr,"窗口B");
		Thread thread3 = new Thread(mr,"窗口C");
		Thread thread4 = new Thread(mr,"窗口D");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
