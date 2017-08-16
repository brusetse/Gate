package com.bruse.course.task.hw0821.homework4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	/**
	 *  【1】创建User类，包含以下属性name:String,age:int,gender enum,重写toString方法显示对象的信息
	 *	【2】使用BufferedWriter写入文件以“,”分隔
	 *	【3】使用BufferedReader读取信息并进行分割，还原成对象，调用对象的toString方法输出对象的信息
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		File file = new File("User信息");
		if(!file.exists()){
			file.createNewFile();
		}else
			System.out.println("文件已存在");
		//创建输出缓冲流
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		//创建输入缓冲流
		BufferedReader br = new BufferedReader(new FileReader(file));

		bw.write("张三");
//		bw.newLine();
		bw.write(",");
		bw.write("23");
		bw.write(",");
		bw.write("男");
		bw.close();

//		int length = 0;
//		while((length = br.read())!=-1 && length!=44){
//			
//		}
		char ch[] = new char[1024];
		int length = br.read(ch);
		String string = new String(ch, 0, length);
		String str[] = string.split(",");

//		User u = new User(br.readLine(),br.read(),gender.valueOf(br.readLine()));
		User u = new User(str[0],Integer.valueOf(str[1]), User.gender.valueOf(str[2]));

		br.close();
		System.out.println(u);
	}
}
