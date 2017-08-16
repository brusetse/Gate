package com.bruse.course.io.file;

import java.io.File;

public class DirectoryDemo {

	public static void main(String[] args) {
		//创建File对象
		File file = new File ("D:\\a\\b\\c");
		//只能创建单层目录，如果父目录不存在，就不创建
		if(!file.exists()){
			file.mkdir();
		}else{
			System.out.println("文件已存在");
		}
		//创建多层目录，如果父目录不存在，自动创建父目录
		if(!file.exists()){
			file.mkdirs();
		}else{
			System.out.println("文件已存在");
		}
		//返回此抽象路径名的路径名字符串
		System.out.println(file.toString());
	}
}