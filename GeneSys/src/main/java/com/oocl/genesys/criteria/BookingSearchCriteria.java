package com.oocl.genesys.criteria;

public class BookingSearchCriteria {
	
	private String fromCity;
	private String toCity;
	private String bkgNum;
	private String cntrNum;
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getBkgNum() {
		return bkgNum;
	}
	public void setBkgNum(String bkgNum) {
		this.bkgNum = bkgNum;
	}
	public String getCntrNum() {
		return cntrNum;
	}
	public void setCntrNum(String cntrNum) {
		this.cntrNum = cntrNum;
	}
}