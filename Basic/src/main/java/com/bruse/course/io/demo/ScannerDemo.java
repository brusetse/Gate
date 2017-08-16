package com.bruse.course.io.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("a.txt"));

		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}

		scanner.close();
	}
}