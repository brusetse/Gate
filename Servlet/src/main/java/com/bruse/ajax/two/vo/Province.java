package com.bruse.ajax.two.vo;

public class Province {

	private int provinceID;
	private String province;
	public Province(int provinceID, String province) {
		super();
		this.provinceID = provinceID;
		this.province = province;
	}
	public Province() {
		super();
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
