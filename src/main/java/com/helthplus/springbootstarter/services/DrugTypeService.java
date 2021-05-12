package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.DrugTypeDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;

public interface DrugTypeService {
	InventoryValidationDTO createDrugType(DrugTypeDTO drugTypeDTO); 

	
	InventoryValidationDTO getAllDrugType(DrugTypeDTO drugTypeDTO);
	
	InventoryValidationDTO deleteDrugType(DrugTypeDTO drugTypeDTO);

}
