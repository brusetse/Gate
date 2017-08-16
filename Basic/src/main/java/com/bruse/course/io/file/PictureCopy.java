package com.bruse.course.io.file;

import java.io.*;

public class PictureCopy {

	public static void main(String[] args) throws IOException {
		File file = new File("a.jpg");

		InputStream is = new FileInputStream("D:\\1.jpg");
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
