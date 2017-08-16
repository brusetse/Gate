package com.bruse.course.thread.demo;

import java.util.Iterator;

public class MyThread extends Thread{

	public void run(){
		for(int i = 0;i < 10;i++){
			System.out.println(Thread.currentThread().getName()+"==========="+i);
		}
	}
}
