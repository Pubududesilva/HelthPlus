package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.MedicineGenericNameDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface MedicineGenericService {
	
	
	UserValidationDTO createMedicineGeneric(MedicineGenericNameDTO genericNameDTO);
	
	UserValidationDTO getAllMedicineGenericByClinicId(MedicineGenericNameDTO genericNameDTO);
	
	UserValidationDTO deleteMedicineGenericById(MedicineGenericNameDTO genericNameDTO);

}
