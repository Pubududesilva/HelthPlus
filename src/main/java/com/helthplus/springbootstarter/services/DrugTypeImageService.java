package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.DrugTypeImageDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;

public interface DrugTypeImageService {
	
	InventoryValidationDTO getAllDrugTypeImage();
	
	InventoryValidationDTO createTypeImage(DrugTypeImageDTO dto);

}
