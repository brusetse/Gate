package com.bruse.course.thread.demo2;

public class TestJoin {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread thread = new Thread(mr);
		thread.start();

		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "--------"+ i);
		}

	}
}
