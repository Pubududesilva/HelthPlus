package com.helthplus.springbootstarter.domain;

import java.util.List;

public class ReportValidation {
	
	private int status;
	
	private int httpCode;
	
	private ErrorDTO error;
	
	private List<RedeemDrugWithDate> redeemDrugWithDates;
	
	private List<LedgerIncomeDTO> ledgerIncomeDTOs;
	
	private List<DailyIncomeDTO> dailyIncomeDTOs;
	
	private ClinicDTO clinicDTO;
	
	private UserDTO userDTO;
	
	private List<DoctorIncomeByMonthly> doctorIncomeByMonthlies;
	
	

	public List<DoctorIncomeByMonthly> getDoctorIncomeByMonthlies() {
		return doctorIncomeByMonthlies;
	}

	public void setDoctorIncomeByMonthlies(List<DoctorIncomeByMonthly> doctorIncomeByMonthlies) {
		this.doctorIncomeByMonthlies = doctorIncomeByMonthlies;
	}

	public List<DailyIncomeDTO> getDailyIncomeDTOs() {
		return dailyIncomeDTOs;
	}

	public void setDailyIncomeDTOs(List<DailyIncomeDTO> dailyIncomeDTOs) {
		this.dailyIncomeDTOs = dailyIncomeDTOs;
	}

	public List<LedgerIncomeDTO> getLedgerIncomeDTOs() {
		return ledgerIncomeDTOs;
	}

	public void setLedgerIncomeDTOs(List<LedgerIncomeDTO> ledgerIncomeDTOs) {
		this.ledgerIncomeDTOs = ledgerIncomeDTOs;
	}

	public ClinicDTO getClinicDTO() {
		return clinicDTO;
	}

	public void setClinicDTO(ClinicDTO clinicDTO) {
		this.clinicDTO = clinicDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public int getStatus() {
		return status;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public ErrorDTO getError() {
		return error;
	}

	public List<RedeemDrugWithDate> getRedeemDrugWithDates() {
		return redeemDrugWithDates;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public void setError(ErrorDTO error) {
		this.error = error;
	}

	public void setRedeemDrugWithDates(List<RedeemDrugWithDate> redeemDrugWithDates) {
		this.redeemDrugWithDates = redeemDrugWithDates;
	}
	
	

}
