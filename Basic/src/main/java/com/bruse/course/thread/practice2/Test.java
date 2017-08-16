package com.bruse.course.thread.practice2;

public class Test {

	public static void main(String[] args) {
		Producer p = new Producer();
		Consumer c = new Consumer();
		MyThread mt = new MyThread(p);
		MyThread2 mt2 = new MyThread2(p, c);
		Thread t = new Thread(mt);
		Thread t2 = new Thread(mt2);
		
		t.start();
		t2.start();
		
	}
}
