package com.oocl.genesys.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="GS_BOOKING")
public class Booking {
	
	@Id
	@SequenceGenerator(name="booking_seq", sequenceName="gs_booking_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_seq")
    private String bkgNum;
	
	
	@NotNull
    @Column(name = "STATUS", nullable = false)
    private int status;
    
	@NotNull
    @Column(name = "IS_VALID_WEIGHT", nullable = false)
    private int isValidWeight;
    
	@NotNull
    @Column(name = "IS_APPROVED", nullable = false)
    private int isApproved;
    
	@NotNull
    @Column(name = "IS_GOOD_CUSTOMER", nullable = false)
    private int isGoodCustomer;
 
	@Size(min=3, max=3)
	@NotNull
    @Column(name = "FROM_CITY", nullable = false)
    private String fromCity;
	
	@Size(min=3, max=3)
	@NotNull
    @Column(name = "TO_CITY", nullable = false)
    private String toCity;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "bkgNum")
	private List<Container> containerList = new ArrayList<Container>();
	
	public String getBkgNum() {
		return bkgNum;
	}

	public void setBkgNum(String bkgNum) {
		this.bkgNum = bkgNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsValidWeight() {
		return isValidWeight;
	}

	public void setIsValidWeight(int isValidWeight) {
		this.isValidWeight = isValidWeight;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public int getIsGoodCustomer() {
		return isGoodCustomer;
	}

	public void setIsGoodCustomer(int isGoodCustomer) {
		this.isGoodCustomer = isGoodCustomer;
	}

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


}

