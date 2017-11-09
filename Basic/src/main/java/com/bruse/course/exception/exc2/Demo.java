package com.bruse.course.exception.exc2;

import org.junit.Test;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		try{
			isTriangle(a, b, c);
			System.out.println("三角形的边长分别为："+a+" "+b+" "+c);
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			System.out.println("三角形的边长不符合规则");
		}
	}

	static void isTriangle(int a,int b,int c) throws IllegalArgumentException{
		if((a>=b+c)||(b>=a+c)||(c>=a+b))
			throw new IllegalArgumentException("a,b,c不能构成三角形");

	}

	public void aaa() throws KobeException {
		if (Math.random() < 0.5) {
			throw new KobeException("蜗壳又打铁了");
		}
	}

	@Test
	public void test() {
		try {
			aaa();
		} catch (KobeException e) {
			System.out.println(e);
		}
	}
}

class IllegalArgumentException extends Exception{
	IllegalArgumentException(String msg) {
		super(msg);
	}
}

class KobeException extends Exception {
	public KobeException(String message) {
		super(message);
	}
}