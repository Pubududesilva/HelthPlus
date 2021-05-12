package com.helthplus.springbootstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vm_drug_balance")
public class DrugBalanceDTO {

	@Id
	@Column(name="brand_id")
	private long brandId;
	
	@Column(name="insert_amount")
	private long insertAmount;
	
	@Column(name="minimum_qty")
	private long minimumQty;
	
	@Column(name="redeem_amount")
	private long redeemAmount;
	
	@Column(name="balance_amount")
	private long balanceAmount;
	
	@Column(name="drug_persentage")
	private float drugPersentage;
	
	
	@Column(name="insert_brandname")
	private String insertBrandName;



	public long getBrandId() {
		return brandId;
	}


	public long getInsertAmount() {
		return insertAmount;
	}


	public long getMinimumQty() {
		return minimumQty;
	}


	public long getRedeemAmount() {
		return redeemAmount;
	}


	public long getBalanceAmount() {
		return balanceAmount;
	}


	public float getDrugPersentage() {
		return drugPersentage;
	}


	public String getInsertBrandName() {
		return insertBrandName;
	}



	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}


	public void setInsertAmount(long insertAmount) {
		this.insertAmount = insertAmount;
	}


	public void setMinimumQty(long minimumQty) {
		this.minimumQty = minimumQty;
	}


	public void setRedeemAmount(long redeemAmount) {
		this.redeemAmount = redeemAmount;
	}


	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public void setDrugPersentage(float drugPersentage) {
		this.drugPersentage = drugPersentage;
	}


	public void setInsertBrandName(String insertBrandName) {
		this.insertBrandName = insertBrandName;
	}
	
	
	
	
	

}
