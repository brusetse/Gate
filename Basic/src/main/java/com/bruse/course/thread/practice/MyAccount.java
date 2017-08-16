package com.bruse.course.thread.practice;

public class MyAccount implements Runnable{

	private Account account;
	
	public MyAccount(Account account){
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 5 ; i++){
			account.getMoney();
		}
	}

}
