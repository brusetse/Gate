package com.bruse.ajax.two.vo;

public class City {

	private int cityID;
	private String city;
	private int father;
	public City() {
		super();
	}
	public City(int cityID, String city, int father) {
		super();
		this.cityID = cityID;
		this.city = city;
		this.father = father;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getFather() {
		return father;
	}
	public void setFather(int father) {
		this.father = father;
	}

}
