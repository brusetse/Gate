package com.bruse.course.thread.practice;

public class Account {

	private int balance = 500;

	public Account() {
		super();
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public synchronized void getMoney(){
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(balance - 200 >= 0){
			balance -= 200;
			System.out.println(Thread.currentThread().getName()+"取款成功!");
			System.out.println("余额为："+balance);
		}else{
			System.out.println("余额不足，取款失败！");
			System.out.println("余额为："+balance);
		}
	}
}