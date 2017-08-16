package com.bruse.course.other;

import java.util.Scanner;

public class Dash {

	public static void main(String[] args) {
		set();
		get();
	}

	public static void set(){
		Scanner s = new Scanner(System.in);
		System.out.println("请输入QQ：");
		String qq = s.next();
		System.out.println("请输入密码：");
		String qq1 = s.next();
		s.close();
	}

	public static void get(){
		Scanner s = new Scanner(System.in);
		System.out.print("请输入邮件id：");
		int a = s.nextInt();
		System.out.print("请输入标题：");
		String b  = s.next();
		System.out.print("请输入内容：");
		String c = s.next();
		System.out.print("请输入状态：");
		int d = s.nextInt();
		s.close();
	}
}
