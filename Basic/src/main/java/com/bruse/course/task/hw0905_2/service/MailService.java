package com.bruse.course.task.hw0905_2.service;

import com.bruse.course.task.hw0905_2.po.Tb_User;
import com.bruse.course.task.hw0905_2.vo.ReceiveMail;

import java.util.List;


public interface MailService{
	public Tb_User queryUser(String qq, String password);
	
	public void addMail(int userid, String title, String content, int status);
	
	public List<ReceiveMail> queryReceiveMail(int userid);
}