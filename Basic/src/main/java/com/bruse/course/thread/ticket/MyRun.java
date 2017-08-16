package com.bruse.course.thread.ticket;

public class MyRun implements Runnable{

	private int ticket = 5;
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++){
			synchronized (this) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(ticket>0){
					System.out.println(Thread.currentThread().getName()+"正在售卖第"+(ticket--)+"张票");
				}
			}
		}
	}

}
