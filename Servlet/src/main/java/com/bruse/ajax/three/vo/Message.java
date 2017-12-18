package com.bruse.ajax.three.vo;

public class Message {

	private int id;
	private String content;
	private String username;
	public Message(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public Message() {
		super();
	}
	public Message(int id, String content, String username) {
		super();
		this.id = id;
		this.content = content;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
