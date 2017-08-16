package com.bruse.course.thread.practice2;

public class MyThread implements Runnable{

	private Producer p;

	public MyThread(Producer p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for(int i = 1 ; i <= 10 ; i++){
			p.pro();
		}
	}

}
