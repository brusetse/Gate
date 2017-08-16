package com.bruse.course.task.hw0821.homework2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PictureCopy {

	/**
	 * 将一张图片复制到当前项目中
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("输出图片.jpg");
		if(!file.exists())
			file.createNewFile();
		else
			System.out.println("文件已存在");

		InputStream is = new FileInputStream("输入图片.jpg");
		OutputStream os = new FileOutputStream(file);
		// byte b[] = new byte[1024];
		int length = 0;
		while (length != -1) {
			length = is.read();
			os.write(length);
		}

		os.close();
		is.close();
	}
}