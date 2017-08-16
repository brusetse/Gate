package com.bruse.course.thread.practice2;

public class Consumer {

	public synchronized void buy(){
		System.out.println(Thread.currentThread().getName()+"取走了1瓶水");
	}
}
