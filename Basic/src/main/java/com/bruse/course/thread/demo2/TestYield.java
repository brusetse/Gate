package com.bruse.course.thread.demo2;

public class TestYield {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread thread = new Thread(mr);
		thread.start();
		
		Thread main = Thread.currentThread();
		for(int i = 0;i<10;i++){
			if(i==3){
				main.yield();
			}
			System.out.println(Thread.currentThread().getName() + "--------"+ i);
		}
	}
}
