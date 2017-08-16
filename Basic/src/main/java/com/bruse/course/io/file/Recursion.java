package com.bruse.course.io.file;

import java.io.File;

public class Recursion {
	//递归遍历所有文件
	public static void main(String[] args) {
		File file = new File("D:");
		findfile(file);
	}

	public static void findfile(File file) {
		File[] f = file.listFiles();
		if (file.isFile())
			System.out.println(file.getAbsolutePath());
		else
			for (File file2 : f)
				findfile(file2);

	}
}