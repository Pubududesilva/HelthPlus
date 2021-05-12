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
@Table(name="helthplus301_pls_investigation")
public class InvestigationDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="investgation_description")
	private String investgationDescription;
	
	@Column(name="investgation_result")
	private String investgationResult;
	
	@Column(name="isResultEntered")
	private boolean isResultEnted;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "investigationDTO")
	private DiagnosisDTO diagnosis;

	public long getId() {
		return id;
	}

	public boolean isResultEnted() {
		return isResultEnted;
	}

	public void setResultEnted(boolean isResultEnted) {
		this.isResultEnted = isResultEnted;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvestgationDescription() {
		return investgationDescription;
	}

	public void setInvestgationDescription(String investgationDescription) {
		this.investgationDescription = investgationDescription;
	}

	public String getInvestgationResult() {
		return investgationResult;
	}

	public void setInvestgationResult(String investgationResult) {
		this.investgationResult = investgationResult;
	}


}
