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
@Table(name="helthplus301_pls_drug_type")
public class DrugTypeDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="type")
	private String type;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="clinic_id")
	private long clinicId;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@Column(name="img_id")
	private Long imageId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "medicine_brand_name_id")
	private MedicineBrandNameDTO medicineBrandNameDTO;

	public long getUserId() {
		return userId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public MedicineBrandNameDTO getMedicineBrandNameDTO() {
		return medicineBrandNameDTO;
	}

	public void setMedicineBrandNameDTO(MedicineBrandNameDTO medicineBrandNameDTO) {
		this.medicineBrandNameDTO = medicineBrandNameDTO;
	}
	
	

}
