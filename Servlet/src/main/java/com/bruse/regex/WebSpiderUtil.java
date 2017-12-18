package com.bruse.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class WebSpiderUtil {

	public static StringBuffer spiderHtml(String link){
		StringBuffer sb = new StringBuffer();
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			URL url = new URL(link);
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
			conn.addRequestProperty("Referer", link);
			in = conn.getInputStream();
			isr = new InputStreamReader(in,"utf-8");
			br = new BufferedReader(isr);
			
			String temp = "";
			while((temp=br.readLine())!=null){
				sb.append(temp+"\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sb;
	}
	
	public static void main(String[] args) {
		StringBuffer spiderHtml = spiderHtml("http://www.gzsxt.cn");
		System.out.println(spiderHtml);
	}
	
}
