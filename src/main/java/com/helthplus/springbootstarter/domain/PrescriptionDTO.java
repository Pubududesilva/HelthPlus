package com.helthplus.springbootstarter.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="helthplus301_pls_prescription")
public class PrescriptionDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="is_dipensary_print")
	private String isDipensaryPrint;
	
	@Column(name="is_pharmacy_print")
	private boolean isPharmacyPrint;
	
	@Column(name="is_drug_issue")
	private boolean isDrugIssue;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "prescriptionDTO")
	private DiagnosisDTO diagnosis;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "prescription_id", referencedColumnName = "id")
	List<PrescribeDrugDTO> prescribeDrugDTO = new ArrayList<>();
	
	public boolean isDrugIssue() {
		return isDrugIssue;
	}

	public void setDrugIssue(boolean isDrugIssue) {
		this.isDrugIssue = isDrugIssue;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "prescription_id", referencedColumnName = "id")
	List<RedeemPrescribeDrugDTO> redeemPrescribeDrugDTOs = new ArrayList<>();
	

	public List<RedeemPrescribeDrugDTO> getRedeemPrescribeDrugDTOs() {
		return redeemPrescribeDrugDTOs;
	}

	public void setRedeemPrescribeDrugDTOs(List<RedeemPrescribeDrugDTO> redeemPrescribeDrugDTOs) {
		this.redeemPrescribeDrugDTOs = redeemPrescribeDrugDTOs;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIsDipensaryPrint() {
		return isDipensaryPrint;
	}

	public void setIsDipensaryPrint(String isDipensaryPrint) {
		this.isDipensaryPrint = isDipensaryPrint;
	}

	public boolean isPharmacyPrint() {
		return isPharmacyPrint;
	}

	public void setPharmacyPrint(boolean isPharmacyPrint) {
		this.isPharmacyPrint = isPharmacyPrint;
	}
 
	public List<PrescribeDrugDTO> getPrescribeDrugDTO() {
		return prescribeDrugDTO;
	}

	public void setPrescribeDrugDTO(List<PrescribeDrugDTO> prescribeDrugDTO) {
		this.prescribeDrugDTO = prescribeDrugDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String isDipensaryPrint() {
		return isDipensaryPrint;
	}

	public void setDipensaryPrint(String isDipensaryPrint) {
		this.isDipensaryPrint = isDipensaryPrint;
	}

	
	

}
