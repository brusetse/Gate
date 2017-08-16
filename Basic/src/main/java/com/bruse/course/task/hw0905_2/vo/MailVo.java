package com.bruse.course.task.hw0905_2.vo;

import com.bruse.course.task.hw0905_2.util.MyClob;

import java.util.Date;



public class MailVo {

	private int qq;
	private Date sendtime;
	private String title;
	private MyClob content;
	private int mail_id;
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MyClob getContent() {
		return content;
	}
	public void setContent(MyClob content) {
		this.content = content;
	}
	public int getMail_id() {
		return mail_id;
	}
	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}
	public MailVo(int qq, Date sendtime, String title, MyClob content,
			int mail_id) {
		super();
		this.qq = qq;
		this.sendtime = sendtime;
		this.title = title;
		this.content = content;
		this.mail_id = mail_id;
	}
	
}
