package com.helthplus.springbootstarter.services;

import java.util.List;

import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.PrescribeDrugDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface MedicineBrandSettingService {
	
	InventoryValidationDTO createMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO); 

	
	InventoryValidationDTO getAllMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO);
	
	InventoryValidationDTO getMedicineBrandSettingById(PrescribeDrugDTO prescribeDrugDTO);
	
	InventoryValidationDTO deleteMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO);
}
