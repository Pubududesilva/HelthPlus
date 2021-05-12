package com.helthplus.springbootstarter.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="helthplus301_pls_patient")
public class PatientDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="nic")
	private String nic;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="emergency_contact_name")
	private String emergencyContactName;
	
	@Column(name="emergency_contact_number")
	private String emergencyContactNumber;
	
	@Column(name="is_owner")
	private boolean isOwner;
	
	@Column(name="owner_id")
	private String ownerId;
	
	@Column(name="is_manager")
	private boolean isManager;
	
	@Column(name="manager_owner_id")
	private String managerOwnerId;
	
	@Column(name="is_patient")
	private boolean isPatient;
	
	@Column(name="patient_owner_manager_id")
	private String patientOwnerId;
	
	@Column(name="creted_date")
	private Date createdDate;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientDTO")
	private DoctorDTO doctorDto;

	@Column(name="clinic_id")
	private String clinicId;

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "diagnosis_id")
	private DiagnosisDTO diagnosisDTO;
	
	@Column(name="doctor_slmc_number")
	private String doctorSlmc;
	
	@Column(name="doctor_id")
	private Long doctorId;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public long getId() {
		return id;
	}

	public String getDoctorSlmc() {
		return doctorSlmc;
	}

	public void setDoctorSlmc(String doctorSlmc) {
		this.doctorSlmc = doctorSlmc;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public String getManagerOwnerId() {
		return managerOwnerId;
	}

	public void setManagerOwnerId(String managerOwnerId) {
		this.managerOwnerId = managerOwnerId;
	}

	public boolean isPatient() {
		return isPatient;
	}

	public void setPatient(boolean isPatient) {
		this.isPatient = isPatient;
	}

	public String getPatientOwnerId() {
		return patientOwnerId;
	}

	public void setPatientOwnerId(String patientOwnerId) {
		this.patientOwnerId = patientOwnerId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public DiagnosisDTO getDiagnosisDTO() {
		return diagnosisDTO;
	}

	public void setDiagnosisDTO(DiagnosisDTO diagnosisDTO) {
		this.diagnosisDTO = diagnosisDTO;
	}
	



}
