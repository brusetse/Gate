package com.bruse.course.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		//获取主机名，IP地址
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia);
		//获取主机名
		System.out.println(ia.getHostName());
		//获取主机地址
		System.out.println(ia.getHostAddress());

		InetAddress ia2 = InetAddress.getByName("www.baidu.com");
		//通过主机名获取IP地址
		System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
		//通过IP地址获取主机名
		System.out.println(InetAddress.getByAddress("192.168.1.126".getBytes()).getHostName());
	}
}