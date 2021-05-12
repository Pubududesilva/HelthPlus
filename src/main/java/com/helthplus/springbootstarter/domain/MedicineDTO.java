package com.helthplus.springbootstarter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helthplus301_pls_medicine_name")
public class MedicineDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="clinic_id")
	private long clinicId;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="generic_medicine_id")
	private long genericmedicineId;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="drug_type")
	private String drugType;
	
	@Column(name="drug_strength")
	private String drugStrength;
	
	@Column(name="unit")
	private Long unit;
	
	@Column(name="minimum_qty")
	private Integer minimumQty;
	
	@Column(name="selling_price")
	private Double sellingPrice;
	
	@Column(name="manufacture_date")
	private Date manufactureDate;
	
	@Column(name="expiry_date")
	private Date expiryDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getGenericmedicineId() {
		return genericmedicineId;
	}

	public void setGenericmedicineId(long genericmedicineId) {
		this.genericmedicineId = genericmedicineId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getDrugStrength() {
		return drugStrength;
	}

	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public Integer getMinimumQty() {
		return minimumQty;
	}

	public void setMinimumQty(Integer minimumQty) {
		this.minimumQty = minimumQty;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
}
