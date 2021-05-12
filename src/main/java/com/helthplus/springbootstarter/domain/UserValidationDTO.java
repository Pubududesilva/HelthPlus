package com.helthplus.springbootstarter.domain;

import java.util.List;

public class UserValidationDTO {
	private String accessToken;
	
	private List<PatientDTO> PatientDTO;
	
	private List<DiagnosisDTO> diagnosisDTOs;
	
	private List<DoctorDTO> userDTos;
	
	private List<AllergyDTO> allergyDTOs;
	
	private ClinicDTO clinicDTO;
	
	private RollDTO rollDTO;
	
	private UserDTO userDTO;
	
	private List<UserDTO> clinicDoctors;
	
	private List<MedicineGenericNameDTO> listMedicineGenericNameDTO;
	
	public List<MedicineGenericNameDTO> getListMedicineGenericNameDTO() {
		return listMedicineGenericNameDTO;
	}
	public void setListMedicineGenericNameDTO(List<MedicineGenericNameDTO> listMedicineGenericNameDTO) {
		this.listMedicineGenericNameDTO = listMedicineGenericNameDTO;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public ClinicDTO getClinicDTO() {
		return clinicDTO;
	}
	public void setClinicDTO(ClinicDTO clinicDTO) {
		this.clinicDTO = clinicDTO;
	}
	public RollDTO getRollDTO() {
		return rollDTO;
	}
	public void setRollDTO(RollDTO rollDTO) {
		this.rollDTO = rollDTO;
	}
	public List<PatientDTO> getPatientDTO() {
		return PatientDTO;
	}
	public void setPatientDTO(List<PatientDTO> PatientDTO) {
		this.PatientDTO = PatientDTO;
	}
	private int status;
	
	private int httpCode;
	

	public List<UserDTO> getClinicDoctors() {
		return clinicDoctors;
	}
	public void setClinicDoctors(List<UserDTO> clinicDoctors) {
		this.clinicDoctors = clinicDoctors;
	}
	private List<ValidationFactorsDTO> validationFactor;
	
	private ErrorDTO error;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public List<AllergyDTO> getAllergyDTOs() {
		return allergyDTOs;
	}
	public void setAllergyDTOs(List<AllergyDTO> allergyDTOs) {
		this.allergyDTOs = allergyDTOs;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public List<ValidationFactorsDTO> getValidationFactor() {
		return validationFactor;
	}
	public void setValidationFactor(List<ValidationFactorsDTO> validationFactor) {
		this.validationFactor = validationFactor;
	}
	public ErrorDTO getError() {
		return error;
	}
	public void setError(ErrorDTO error) {
		this.error = error;
	}
	public List<DiagnosisDTO> getDiagnosisDTOs() {
		return diagnosisDTOs;
	}
	public void setDiagnosisDTOs(List<DiagnosisDTO> diagnosisDTOs) {
		this.diagnosisDTOs = diagnosisDTOs;
	}
	public List<DoctorDTO> getUserDTos() {
		return userDTos;
	}
	public void setUserDTos(List<DoctorDTO> userDTos) {
		this.userDTos = userDTos;
	}
	
	

}


