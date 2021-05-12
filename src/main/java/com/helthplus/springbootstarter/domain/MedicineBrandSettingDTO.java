package com.helthplus.springbootstarter.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="helthplus301_pls_medicle_brand_setting")
public class MedicineBrandSettingDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="medicine_generic_name_id")
	private long medicleGenericId;
	
	@Column(name="user_id")
	private long userId;
	
//	@Column(name="supplier_id")
//	private long supplierId;create_date
	
	@Column(name="selling_price")
	private Double sellingPrice;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="minimum_qty")
	private Integer minimumQty;
	
	@Column(name="clinic_id")
	private long clinicId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medicileBrandSettingDTO")
	private MedicineGenericNameDTO medicineGenericNameDTO;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "medicine_brand_name_id")
	private MedicineBrandNameDTO medicineBrandNameDTO;
	

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public MedicineBrandNameDTO getMedicineBrandNameDTO() {
		return medicineBrandNameDTO;
	}

	public void setMedicineBrandNameDTO(MedicineBrandNameDTO medicineBrandNameDTO) {
		this.medicineBrandNameDTO = medicineBrandNameDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMedicleGenericId() {
		return medicleGenericId;
	}

	public void setMedicleGenericId(long medicleGenericId) {
		this.medicleGenericId = medicleGenericId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getMinimumQty() {
		return minimumQty;
	}

	public void setMinimumQty(Integer minimumQty) {
		this.minimumQty = minimumQty;
	}

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}
	
	

}
