package com.bruse.course.task.hw0821.homework1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	/**
	 * 递归完成D盘所有文件的遍历，要求将绝对路径写进一个txt文件中
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("D:");
		File filed = new File("D盘文件遍历.txt");
		if(!filed.exists())
			filed.createNewFile();
		else
			System.out.println("文件已存在");
		FileWriter fw = new FileWriter(filed);
		findfile(file,fw);
		fw.close();
	}

	public static void findfile(File file,FileWriter fw) throws IOException {
		File[] f = file.listFiles();
		if (file.isFile()){
			fw.write(file.getAbsolutePath());
			fw.write("\r\n");
		}
		else
			for (File file2 : f)
				findfile(file2,fw);
	}
}