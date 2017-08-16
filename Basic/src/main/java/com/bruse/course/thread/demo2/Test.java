package com.bruse.course.thread.demo2;

public class Test {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		new Thread(mr).start();
		Thread thread = Thread.currentThread();
		//�����߳����ȼ�
		thread.setPriority(10);
		
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"--------"+i);
		}
	}
}
