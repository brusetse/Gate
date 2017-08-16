package com.bruse.course.thread.demo2;

public class ThreadDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// 获取当前线程
		Thread thread = Thread.currentThread();
		//获取线程的名称
		System.out.println(thread.getName());
		//获取线程的优先级
		System.out.println(thread.getPriority());

		//获取线程的最高优先级和最低优先级、默认优先级
		System.out.println(thread.MAX_PRIORITY);
		System.out.println(thread.MIN_PRIORITY);
		System.out.println(thread.NORM_PRIORITY);
		//线程休眠
		try {
			thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
