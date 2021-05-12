package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;

public interface SupplierService {
	
	InventoryValidationDTO createSupplier(SupplierDTO supplierDTO); 

	
	InventoryValidationDTO getAllSupplier(SupplierDTO supplierDTO);
	
	InventoryValidationDTO deleteSupplier(SupplierDTO supplierDTO);


}
