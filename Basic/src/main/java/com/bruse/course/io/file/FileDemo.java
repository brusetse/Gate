package com.bruse.course.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\a.txt");
		//创建文件
		if(!file.exists()){
			file.createNewFile();
		}else{
			System.out.println("文件已存在");
		}
		//删除file
		//file.delete();

		System.out.println(file.canExecute());//文件是否可执行
		System.out.println(file.canRead());//文件是否可读
		System.out.println(file.canWrite());//文件是否可写

		File f = new File("a.txt");
		f.createNewFile();
		//内存地址是否相等
		System.out.println(file==f);
		//文件内容是否相等
		System.out.println(file.equals(f));
		//返回绝对路径
		System.out.println(file.getAbsolutePath());
		System.out.println(f.getAbsolutePath());
		//返回相对路径
		System.out.println(file.getPath());
		System.out.println(f.getPath());
		//获取名称
		System.out.println(file.getName());
		//获取父目录名称
		System.out.println(file.getParent());
		//判断是否是绝对路径
		System.out.println(file.isAbsolute());
		System.out.println(f.isAbsolute());
		//判断是否是目录
		System.out.println(file.isDirectory());
		//判断是否是文件
		System.out.println(file.isFile());
		//获取最后一次修改时间
		System.out.println(file.lastModified());
		//获取文件长度
		System.out.println(file.length());
		//返回目录下的文件和目录，只有目录能调用，返回字符串数组
		File f2 = new File("D:");
		String[] string = f2.list();
		for (String string2 : string) {
			System.out.println(string2);
		}
		//返回路径名数组
		File f3[] = f2.listFiles();
		for (File file2 : f3) {
			System.out.println(file2+"---");
		}
	}
}