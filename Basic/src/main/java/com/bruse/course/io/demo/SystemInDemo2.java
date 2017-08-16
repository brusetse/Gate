package com.bruse.course.io.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInDemo2 {

	public static void main(String[] args) throws IOException {
		//创建缓冲输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//创建字符串容器
		StringBuffer stringBuffer = new StringBuffer();
		//读取数据
		String string = null;
		while((string=br.readLine())!=null){
			stringBuffer.append(string);
			stringBuffer.append("\n");
			if(string.equals("再见"))
				break;
		}

		System.out.println(stringBuffer);

		br.close();
	}
}
