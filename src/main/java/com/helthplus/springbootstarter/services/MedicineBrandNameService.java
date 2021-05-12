package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;

public interface MedicineBrandNameService {
	InventoryValidationDTO createMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO); 

	
	InventoryValidationDTO getAllMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO);
	
	InventoryValidationDTO deleteMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO);

}
