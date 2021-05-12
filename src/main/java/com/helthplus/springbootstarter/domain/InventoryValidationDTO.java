package com.helthplus.springbootstarter.domain;

import java.util.List;

public class InventoryValidationDTO {
	
	private int status;
	
	private int httpCode;
	
	private ErrorDTO error;
	
	private ClinicDTO clinicDTO;
	
	private UserDTO userDTO;
	
	List<MedicineBrandSettingDTO> medicineBrandSettingDTOs;
	
	List<SupplierDTO> supplierDTOs;
	
	List<MedicineGenericNameDTO> medicineGenericNameDTOs;
	
	List<MedicineBrandNameDTO> medicineBrandNameDTOs;
	
	List<DrugTypeDTO> drugTypeDTOs;
	
	List<DrugTypeImageDTO> drugTypeImageDTOs;
	
	List<DrugBalanceDTO> balanceDTOs;

	public List<DrugTypeImageDTO> getDrugTypeImageDTOs() {
		return drugTypeImageDTOs;
	}

	public void setDrugTypeImageDTOs(List<DrugTypeImageDTO> drugTypeImageDTOs) {
		this.drugTypeImageDTOs = drugTypeImageDTOs;
	}




	public ClinicDTO getClinicDTO() {
		return clinicDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setClinicDTO(ClinicDTO clinicDTO) {
		this.clinicDTO = clinicDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public List<DrugBalanceDTO> getBalanceDTOs() {
		return balanceDTOs;
	}

	public void setBalanceDTOs(List<DrugBalanceDTO> balanceDTOs) {
		this.balanceDTOs = balanceDTOs;
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

	public ErrorDTO getError() {
		return error;
	}

	public void setError(ErrorDTO error) {
		this.error = error;
	}

	public List<MedicineBrandSettingDTO> getMedicineBrandSettingDTOs() {
		return medicineBrandSettingDTOs;
	}

	public void setMedicineBrandSettingDTOs(List<MedicineBrandSettingDTO> medicineBrandSettingDTOs) {
		this.medicineBrandSettingDTOs = medicineBrandSettingDTOs;
	}

	public List<SupplierDTO> getSupplierDTOs() {
		return supplierDTOs;
	}

	public void setSupplierDTOs(List<SupplierDTO> supplierDTOs) {
		this.supplierDTOs = supplierDTOs;
	}

	public List<MedicineGenericNameDTO> getMedicineGenericNameDTOs() {
		return medicineGenericNameDTOs;
	}

	public void setMedicineGenericNameDTOs(List<MedicineGenericNameDTO> medicineGenericNameDTOs) {
		this.medicineGenericNameDTOs = medicineGenericNameDTOs;
	}

	public List<MedicineBrandNameDTO> getMedicineBrandNameDTOs() {
		return medicineBrandNameDTOs;
	}

	public void setMedicineBrandNameDTOs(List<MedicineBrandNameDTO> medicineBrandNameDTOs) {
		this.medicineBrandNameDTOs = medicineBrandNameDTOs;
	}

	public List<DrugTypeDTO> getDrugTypeDTOs() {
		return drugTypeDTOs;
	}

	public void setDrugTypeDTOs(List<DrugTypeDTO> drugTypeDTOs) {
		this.drugTypeDTOs = drugTypeDTOs;
	}
	
	

}
