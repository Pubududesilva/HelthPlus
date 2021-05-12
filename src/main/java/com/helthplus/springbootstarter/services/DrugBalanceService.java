package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;

public interface DrugBalanceService {
	
	InventoryValidationDTO getDrugById(MedicineBrandNameDTO brandNameDTO);
	
	InventoryValidationDTO getAllDrugByClinicId(MedicineBrandSettingDTO brandSettingDTO);
}
