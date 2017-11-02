package com.oocl.genesys.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="GS_BOOKING")
public class Booking implements Serializable{
	
	@Id
	@Column(name = "BKG_ID", nullable = false)
	@SequenceGenerator(name="booking_seq", sequenceName="gs_booking_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_seq")
    private long bkgId;
	
	@NotNull
    @Column(name = "BKG_NUM", nullable = false)
	private String bkgNum;
	
	@NotNull
    @Column(name = "STATUS", nullable = false)
    private int status;
    
	@NotNull
    @Column(name = "IS_VALID_WEIGHT", nullable = false)
    private int isValidWeight;
    
	@NotNull
    @Column(name = "IS_APPROVED_DOC", nullable = false)
    private int isApprovedDoc;
    
	@NotNull
    @Column(name = "IS_GOOD_CUSTOMER", nullable = false)
    private int isGoodCustomer;
	
	@Size(max=40)
	@NotNull
    @Column(name = "CONSIGNEE", nullable = false)
    private String consignee;
	
	@Size(max=40)
	@NotNull
    @Column(name = "SHIPPER", nullable = false)
    private String shipper;
 
	@Size(min=3, max=3)
	@NotNull
    @Column(name = "FROM_CITY", nullable = false)
    private String fromCity;
	
	@Size(min=3, max=3)
	@NotNull
    @Column(name = "TO_CITY", nullable = false)
    private String toCity;

	@Column(name = "IS_DELETED", nullable = true)
    private int isDeleted;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Container.class, mappedBy= "booking",cascade={CascadeType.ALL}, orphanRemoval = true)
	private List<Container> containerList = new ArrayList<Container>();
	
	public long getBkgId() {
		return bkgId;
	}

	public void setBkgId(long bkgId) {
		this.bkgId = bkgId;
	}
	
	public List<Container> getContainerList() {
		return containerList;
	}

	public void setContainerList(List<Container> containerList) {
		this.containerList = containerList;
	}

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

	public int getIsApprovedDoc() {
		return isApprovedDoc;
	}

	public void setIsApprovedDoc(int isApprovedDoc) {
		this.isApprovedDoc = isApprovedDoc;
	}

	public int getIsGoodCustomer() {
		return isGoodCustomer;
	}

	public void setIsGoodCustomer(int isGoodCustomer) {
		this.isGoodCustomer = isGoodCustomer;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
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

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


}

