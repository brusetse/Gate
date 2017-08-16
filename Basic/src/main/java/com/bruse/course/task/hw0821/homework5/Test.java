package com.bruse.course.task.hw0821.homework5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	/**
	 * 编写一个程序，把a.txt中的单词与b.txt中的单词交替合并到c.txt中，a.txt中的单词用空格分隔b.txt中的单词用回车或空格分隔
	 * @param args
	 * @throws IOException
	 */

	public static int lengthflag;

	public static void main(String[] args) throws IOException {
		//创建a,b输出字符流
		FileWriter fw1 = new FileWriter(new File("a.txt"));
		FileWriter fw2 = new FileWriter(new File("b.txt"));
		//往a.txt中写入数据
		fw1.write("hello ");
		fw1.write("world ");
		fw1.write("here ");
		fw1.close();
		//往 b.txt中写入数据
		fw2.write("java ");
		fw2.write("html ");
		fw2.write("mysql ");
		fw2.close();
		//创建a,b输入字符流
		FileReader fr1 = new FileReader(new File("a.txt"));
		FileReader fr2 = new FileReader(new File("b.txt"));
		//创建c输出字符流
		FileWriter fw3 = new FileWriter(new File("c.txt"));
		//调用a写入到c方法
		aTc(fr1,fr2,fw3);
		//关闭流
		fr1.close();
		fr2.close();
		fw3.close();
	}
	//a写入c方法
	public static void aTc(FileReader fr1,FileReader fr2,FileWriter fw3) throws IOException{
		int length1 = 0;
		//写入字符
		while((length1 = fr1.read())!=32 && length1!=-1){
			fw3.write(length1);
		}
		fw3.write(" ");
		//若a和b都未到末尾，调用b
		if(length1!=-1||lengthflag!=-1)
			bTc(fr1,fr2,fw3);

	}
	//b写入c方法
	public static void bTc(FileReader fr1,FileReader fr2,FileWriter fw3) throws IOException{
		int length2 = 0;
		//写入字符
		while((length2 = fr2.read())!=32 && length2!=-1){
			fw3.write(length2);
		}
		fw3.write(" ");
		//将length2赋值给静态类变量
		lengthflag = length2;
		//调用a
		aTc(fr1,fr2,fw3);
	}

}