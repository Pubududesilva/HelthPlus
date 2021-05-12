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
@Table(name="helthplus301_pls_useremail")
public class DoctorEmailDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long emailId;

	@Column(name="user_id")
	private Long userId;

	@Column(name="email_key")
	private String emailKey;
	
	@Column(name="email")
	private String email;
	
	@Column(name="verify_date")
	private Date verifyDate;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="is_email_verify")
	private boolean isEmailVerify;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEmailDTO")
	private DoctorDTO doctorDTO;


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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
