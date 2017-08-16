package com.bruse.course.task.hw0821.homework3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterAndReaderDemo {

	/**
	 * 使用bufferedWriter将《虞美人》写入到创建的文件中，并将文件中的虞美人打印到控制台输出
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("虞美人.txt");
		//创建文件
		if(!file.exists()){
			file.createNewFile();
		}else{
			System.out.println("文件已存在");
		}
		//创建输出缓冲流
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		//创建输入缓冲流
		BufferedReader br = new BufferedReader(new FileReader(file));
		//写入字符串
		bw.write("春花秋月何时了");
		bw.newLine();
		bw.write("往事知多少");
		bw.newLine();
		bw.write("小楼昨夜又东风");
		bw.newLine();
		bw.write("故国不堪回首月明中");
		bw.newLine();
		//关闭输出流
		bw.close();
		//遍历读取文本行
		String string = null;
		while((string = br.readLine())!=null)
			System.out.println(string);
		//关闭输入流
		br.close();
	}
}
