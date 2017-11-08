package com.bruse.course.thread.demo2;

public class MyRun implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "--------"
					+ i);
		}
	}

}
