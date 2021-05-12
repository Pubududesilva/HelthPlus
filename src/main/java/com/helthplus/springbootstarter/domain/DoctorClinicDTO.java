package com.helthplus.springbootstarter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helthplus301_pls_doctor_clinic")
public class DoctorClinicDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="clinic_id")
	private long clinicId;
	
	@Column(name="doctor_id")
	private long doctorId;
	
	@Column(name="slmc")
	private String slmc;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_email_verify")
	private boolean isEmailVerify;
	
	@Column(name="email_key")
	private String emailKey;
	
	@Column(name="verify_date")
	private Date verifyDate;

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

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getSlmc() {
		return slmc;
	}

	public void setSlmc(String slmc) {
		this.slmc = slmc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerify() {
		return isEmailVerify;
	}

	public void setEmailVerify(boolean isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailKey() {
		return emailKey;
	}

	public void setEmailKey(String emailKey) {
		this.emailKey = emailKey;
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}
	
	
}
