package com.bruse.course.thread.practice;

public class Test {

	public static void main(String[] args) {

		Account acc= new Account();
		MyAccount ma = new MyAccount(acc);
		Thread thread1 = new Thread(ma,"张三");
		Thread thread2 = new Thread(ma,"张三的老婆");

		thread1.start();
		thread2.start();
	}
}