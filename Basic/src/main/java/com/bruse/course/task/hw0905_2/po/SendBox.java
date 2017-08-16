package com.bruse.course.task.hw0905_2.po;

public class SendBox {

	private int sendbox_id;
	private String sendtime;
	private String title;
	private String content;
	private int send_userid;
	private int status;
	public int getSendbox_id() {
		return sendbox_id;
	}
	public void setSendbox_id(int sendbox_id) {
		this.sendbox_id = sendbox_id;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSend_userid() {
		return send_userid;
	}
	public void setSend_userid(int send_userid) {
		this.send_userid = send_userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public SendBox(int sendbox_id, String sendtime, String title,
			String content, int send_userid, int status) {
		super();
		this.sendbox_id = sendbox_id;
		this.sendtime = sendtime;
		this.title = title;
		this.content = content;
		this.send_userid = send_userid;
		this.status = status;
	}
	
}
