package com.bruse.course.thread.practice2;

public class Producer {
	private int num = 0;

	public synchronized void pro(){
		System.out.println(Thread.currentThread().getName()+"生产了1瓶水");
		num++;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
