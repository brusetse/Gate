package com.bruse.jstl;

public class Address {

	private String country;
	private String province;
	private String city;
	private String town;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public Address(String country, String province, String city, String town) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.town = town;
	}
	public Address() {
		super();
	}
}
