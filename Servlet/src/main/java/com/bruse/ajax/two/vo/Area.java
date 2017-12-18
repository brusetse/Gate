package com.bruse.ajax.two.vo;

public class Area {

	private int areaID;
	private String area;
	private int father;
	public Area(int areaID, String area, int father) {
		super();
		this.areaID = areaID;
		this.area = area;
		this.father = father;
	}
	public Area() {
		super();
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getFather() {
		return father;
	}
	public void setFather(int father) {
		this.father = father;
	}
    
}
