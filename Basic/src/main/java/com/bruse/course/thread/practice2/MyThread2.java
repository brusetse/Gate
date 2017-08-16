package com.bruse.course.thread.practice2;

public class MyThread2 implements Runnable{

	private Producer p;
	private Consumer c;
	
	public MyThread2(Producer p, Consumer c) {
		super();
		this.p = p;
		this.c = c;
	}

	@Override
	public void run() {
		for(int i = 1 ; i <= p.getNum() ; i++){
			c.buy();
		}
	}

}
