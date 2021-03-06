package com.oocl.genesys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="GS_CONTAINER")
public class Container implements Serializable{

	@Id
	@SequenceGenerator(name="gs_container_seq", sequenceName="gs_container_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gs_container_seq")
    private int container_id;
	
	@JsonIgnore
	@NotNull
	@ManyToOne(targetEntity=Booking.class)
	@JoinColumn(name="bkg_num", nullable=false,referencedColumnName="BKG_NUM")
    private Booking booking;
	
	@NotNull
    @Column(name = "GROSS_WEIGHT", nullable = false)
    private double grossWeight;
	
	@NotNull
    @Column(name = "NET_WEIGHT", nullable = false)
    private double netWeight;
	
	@NotNull
    @Column(name = "UNIT", nullable = false)
    private int unit;
	
	@NotNull
    @Column(name = "CONTAINER_NUM", nullable = false)
    private String containerNum;
	
	@NotNull
    @Column(name = "CARGO_NATURE", nullable = false)
    private String cargoNature;
	
	@NotNull
    @Column(name = "CONTAINER_TYPE", nullable = false)
    private String containerType;
	
	@Size(max=100)
	@NotNull
    @Column(name = "CARGO_DESC", nullable = false)
    private String cargoDesc;

	public int getContainer_id() {
		return container_id;
	}

	public void setContainer_id(int container_id) {
		this.container_id = container_id;
	}


	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getContainerNum() {
		return containerNum;
	}

	public void setContainerNum(String containerNum) {
		this.containerNum = containerNum;
	}

	public String getCargoNature() {
		return cargoNature;
	}

	public void setCargoNature(String cargoNature) {
		this.cargoNature = cargoNature;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getCargoDesc() {
		return cargoDesc;
	}

	public void setCargoDesc(String cargoDesc) {
		this.cargoDesc = cargoDesc;
	}

}
