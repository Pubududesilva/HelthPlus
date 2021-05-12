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
@Table(name="helthplus301_pls_redeem_prescribe_drug")
public class RedeemPrescribeDrugDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="drug")
	private String drug;

	@Column(name="dose")
	private String dose;

	@Column(name="frequency")
	private String frequency;

	@Column(name="no_of_day")
	private int numberOfDay;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="drug_setting_id")
	private Long drugSettingId;
	
	@Column(name="redeem_quantity")
	private int redeemQuantity;
	
	@Column(name="catagory")
	private String catagory;//Dispensary : D, Pharmacy : P
	
	@Column(name="clinic_id")
	private String clinicId;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="update_date")
	private Date updateDate;

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public long getId() {
		return id;
	}

	public Long getDrugSettingId() {
		return drugSettingId;
	}

	public void setDrugSettingId(Long drugSettingId) {
		this.drugSettingId = drugSettingId;
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

	public int getRedeemQuantity() {
		return redeemQuantity;
	}

	public void setRedeemQuantity(int redeemQuantity) {
		this.redeemQuantity = redeemQuantity;
	}
	
	
	
	
	
}
