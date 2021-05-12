package com.helthplus.springbootstarter.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="helthplus301_pls_prescribe_drug")
public class PrescribeDrugDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="drug")
	private String drug;
	
	@Column(name="drug_setting_id")
	private Long drugSettingId;

	@Column(name="dose")
	private String dose;

	@Column(name="frequency")
	private String frequency;

	@Column(name="no_of_day")
	private int numberOfDay;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="catagory")
	private String catagory;//Dispensary : D, Pharmacy : P
	

	public Long getDrugSettingId() {
		return drugSettingId;
	}

	public void setDrugSettingId(Long drugSettingId) {
		this.drugSettingId = drugSettingId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public int getNumberOfDay() {
		return numberOfDay;
	}

	public void setNumberOfDay(int numberOfDay) {
		this.numberOfDay = numberOfDay;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	
	
	
	
}
