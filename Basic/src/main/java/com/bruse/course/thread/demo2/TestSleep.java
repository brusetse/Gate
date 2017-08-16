package com.bruse.course.thread.demo2;

public class TestSleep {

	public static void main(String[] args) {
		MyRun2 mr = new MyRun2();
		Thread thread = new Thread(mr);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		thread.interrupt();
	}
}
