package com.bruse.course.exception.exc;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		try{
			int a = s.nextInt();
			if(a<0||a>100)
				throw new ScoreException("输入分数不在正确范围内");
			//int a = input();
			System.out.println(a);
		}catch(ScoreException e){
			System.out.println("输入范围有误");
			System.out.println(e.getMessage());
		}
	}

//	static int input() throws ScoreException{
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		if(a<0||a>100)
//		throw new ScoreException("输入分数不在正确范围内");
//		
//		return a;
//	}
}

class ScoreException extends Exception{
	ScoreException(String msg){
		super(msg);
	}
}
