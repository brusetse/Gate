package com.bruse.course.task.hw0815.homework3;

public class Hw3 {
	public static void main(String[] args) {
		for(int i=1;i<=4;i++){
			for(int j=1;j<=i;j++)
				System.out.print(j+"*"+i+"="+j*i+"\t");
			System.out.println();
		}
	}
}