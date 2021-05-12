package com.helthplus.springbootstarter.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="helthplus301_pls_medicine_brand_name")
public class MedicineBrandNameDTO {
	
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
	
	@Column(name="medicine_brand_setting_id")
	private long medicineBrandSettingId;
	
	@Column(name="supplier_id")
	private long supplierId;
	
	@Column(name="drug_type_id")
	private long drugTypeId;
	
	@Column(name="drug_strength")
	private String drugStrength;
	
	@Column(name="unit")
	private Long unit;
	
	@Column(name="purchace_price")
	private Double purchacePrice;
	
	@Column(name="manufacture_date")
	private Date manufactureDate;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medicineBrandNameDTO")
	private SupplierDTO supplierDTO;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medicineBrandNameDTO")
	private MedicineBrandSettingDTO medicineBrandSettingDTO;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medicineBrandNameDTO")
	private DrugTypeDTO drugTypeDTO ;
	

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

	public long getMedicineBrandSettingId() {
		return medicineBrandSettingId;
	}

	public void setMedicineBrandSettingId(long medicineBrandSettingId) {
		this.medicineBrandSettingId = medicineBrandSettingId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getDrugTypeId() {
		return drugTypeId;
	}

	public void setDrugTypeId(long drugTypeId) {
		this.drugTypeId = drugTypeId;
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

	public Double getPurchacePrice() {
		return purchacePrice;
	}

	public void setPurchacePrice(Double purchacePrice) {
		this.purchacePrice = purchacePrice;
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
