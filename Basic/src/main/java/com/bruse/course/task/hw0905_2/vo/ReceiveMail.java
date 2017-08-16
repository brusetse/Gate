package com.bruse.course.task.hw0905_2.vo;

import java.util.Date;

public class ReceiveMail {

	private String qq;
	private String username;
	private String title;
	private Date sendtime;
	private int status;
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ReceiveMail(String qq, String username, String title, Date sendtime,
			int status) {
		super();
		this.qq = qq;
		this.username = username;
		this.title = title;
		this.sendtime = sendtime;
		this.status = status;
	}
	
}
