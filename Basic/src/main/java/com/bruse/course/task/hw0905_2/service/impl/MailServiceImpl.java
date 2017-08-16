package com.bruse.course.task.hw0905_2.service.impl;

import com.bruse.course.task.hw0905_2.dao.MailDao;
import com.bruse.course.task.hw0905_2.dao.impl.MailDaoImpl;
import com.bruse.course.task.hw0905_2.po.Tb_User;
import com.bruse.course.task.hw0905_2.service.MailService;
import com.bruse.course.task.hw0905_2.vo.ReceiveMail;

import java.util.List;


public class MailServiceImpl implements MailService {
	
	MailDao mailDao = new MailDaoImpl();
	
	public Tb_User queryUser(String qq, String password){
		if(!"".equals(password)&&!"".equals(qq)){
			return mailDao.queryUser(qq, password);
		}
		
		return null;
		
	}
	
	public void addMail(int userid,String title,String content,int status){
		mailDao.addMail(userid, title, content, status);
	}
	
	public List<ReceiveMail> queryReceiveMail(int userid){
		return mailDao.queryReceiveMail(userid);
	}
}
