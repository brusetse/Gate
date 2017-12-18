package com.bruse.ajax.one.vo;

public class Student {

	private int student_id;
	private String name;
	private int class_id;
	public Student(int student_id, String name, int class_id) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.class_id = class_id;
	}
	public Student() {
		super();
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
}
