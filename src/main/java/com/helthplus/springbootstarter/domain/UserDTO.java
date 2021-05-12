package com.helthplus.springbootstarter.domain;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helthplus301_user")
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="img_url")
	private String imgFile;

	@Column(name="clinic_id")
	private long clinicId;
	
	@Column(name="role_id")
	private long roleId;
	
	@Column(name="f_name")
	private String firstName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="l_name")
	private String lastName;
	
	@Column(name="slmc_number")
	private String slmcNumber;
	
	@Column(name="creted_date")
	private Date createdDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public String getImgUrl() {
		return imgFile;
	}

	public void setImgUrl(String imgUrl) {
		this.imgFile = imgUrl;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="is_doctor")
	private Boolean isDoctor;

	public String getSlmcNumber() {
		return slmcNumber;
	}

	public void setSlmcNumber(String slmcNumber) {
		this.slmcNumber = slmcNumber;
	}

	public Boolean isDoctor() {
		return isDoctor;
	}

	public void setDoctor(Boolean isDoctor) {
		this.isDoctor = isDoctor;
	}

	public long getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
	
	
}
