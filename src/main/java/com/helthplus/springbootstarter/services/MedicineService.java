package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.MedicineDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface MedicineService {
	
	UserValidationDTO createMedicine(MedicineDTO medicineDTO);

}
