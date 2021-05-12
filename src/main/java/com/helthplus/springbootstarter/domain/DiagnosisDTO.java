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

import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="helthplus301_pls_diagnosis")
public class DiagnosisDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="patient_id")
	private Long patientId;
	
	@Column(name="clinic_id")
	private Long clinicId;
	
	@Column(name="presenting_complain")
	private String presentingComplain;
	
	@Column(name="examination")
	private String examination;
	
	@Column(name="doctor_id")
	private Long doctorId;
	
	@Column(name="doctor_slmc_number")
	private String doctorSlmc;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "diagnosisDTO")
	private PatientDTO patientDTO;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "prescrip_id")
	private PrescriptionDTO prescriptionDTO;


	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "investgation_id")
	private InvestigationDTO investigationDTO;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fee_id")
	private FeeDTO feeDTO;
	
	@Column(name="update_date")
	private Date updateDate;

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

	public String getDoctorSlmc() {
		return doctorSlmc;
	}

	public void setDoctorSlmc(String doctorSlmc) {
		this.doctorSlmc = doctorSlmc;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPresentingComplain() {
		return presentingComplain;
	}

	public void setPresentingComplain(String presentingComplain) {
		this.presentingComplain = presentingComplain;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public PrescriptionDTO getPrescriptionDTO() {
		return prescriptionDTO;
	}

	public void setPrescriptionDTO(PrescriptionDTO prescriptionDTO) {
		this.prescriptionDTO = prescriptionDTO;
	}

	public InvestigationDTO getInvestigationDTO() {
		return investigationDTO;
	}

	public void setInvestigationDTO(InvestigationDTO investigationDTO) {
		this.investigationDTO = investigationDTO;
	}

	public FeeDTO getFeeDTO() {
		return feeDTO;
	}

	public void setFeeDTO(FeeDTO feeDTO) {
		this.feeDTO = feeDTO;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
