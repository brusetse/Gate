package com.bruse.course.task.hw0905_1.vo;

public class EmpVo {

	private String ename;
	private int sal;
	private String dname;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public EmpVo(String ename, int sal, String dname) {
		super();
		this.ename = ename;
		this.sal = sal;
		this.dname = dname;
	}
	
}
