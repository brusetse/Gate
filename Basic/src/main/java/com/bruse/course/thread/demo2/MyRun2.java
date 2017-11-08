package com.bruse.course.thread.demo2;

public class MyRun2 implements Runnable{

	public void run() {
		
		try {
			Thread.sleep(2000);
			System.out.println("sentence 1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sentence 2");
		}finally{
			System.out.println("sentence 3");
		}
	}

}
