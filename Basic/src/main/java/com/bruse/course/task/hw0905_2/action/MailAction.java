package com.bruse.course.task.hw0905_2.action;

import com.bruse.course.task.hw0905_2.po.Tb_User;
import com.bruse.course.task.hw0905_2.service.MailService;
import com.bruse.course.task.hw0905_2.service.impl.MailServiceImpl;
import com.bruse.course.task.hw0905_2.vo.ReceiveMail;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class MailAction {

	public static MailService mailService = new MailServiceImpl();

	public static int queryUserByInput(){
		System.out.println("---------------------------");
		Scanner s = new Scanner(System.in);
		System.out.print("请输入QQ：");
		String qq = s.next();
		System.out.print("请输入密码：");
		String password = s.next();
//		s.close();
		Tb_User u = mailService.queryUser(qq, password);
		System.out.println("QQ："+u.getQq());
		System.out.println("用户名："+u.getUsername());
		System.out.println("注册时间："+u.getRegtime());
		System.out.println("位置："+u.getAddr());
		return u.getUser_id();
	}

	public static void addMailByInput(int userid){
		System.out.println("---------------------------");
		Scanner s = new Scanner(System.in);
		System.out.print("请输入标题：");
		String b  = s.next();
		System.out.print("请输入内容：");
		String c = s.next();
		System.out.print("请输入状态：");
		int d = s.nextInt();
		s.close();
		mailService.addMail(userid, b, c, d);

	}

	public static void queryReceiveMailByInput(int userid){
		System.out.println("---------------------------");
		List list = mailService.queryReceiveMail(userid);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ReceiveMail receiveMail = (ReceiveMail) iterator.next();
			System.out.println("发件人QQ："+receiveMail.getUsername());
			System.out.println("发件人姓名："+receiveMail.getQq());
			System.out.println("标题："+receiveMail.getTitle());
			System.out.println("发送时间："+receiveMail.getSendtime());
			System.out.println("状态："+receiveMail.getStatus());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		}

	}

	public static void panel(){
		int userid = queryUserByInput();
		addMailByInput(userid);
		queryReceiveMailByInput(userid);
	}

	public static void main(String[] args) {
		panel();
	}
}
//2341875 
//dsf425
