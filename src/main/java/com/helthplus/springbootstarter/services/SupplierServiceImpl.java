package com.helthplus.springbootstarter.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;
import com.helthplus.springbootstarter.repositories.SupplierRepository;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public InventoryValidationDTO createSupplier(SupplierDTO supplierDTO) {

		supplierDTO.setCreatedDate(new Date());
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO errorDTO = new ErrorDTO();
		int count = supplierRepository.getSupplierDTO(supplierDTO.getSupplierName(),supplierDTO.getClinicId());
		if(count > 0){
			errorDTO.setError(Constant.SUPPLIER_IS_AVAILABLE);
			errorDTO.setMessage(Constant.SUPPLIER_IS_AVAILABLE);
			inventoryValidationDTO.setError(errorDTO);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
			
		}
		
		SupplierDTO supplietDto =  supplierRepository.save(supplierDTO);

		if(supplietDto != null){
			return getAllSupplier(supplierDTO);
		}else{
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
		}
	}

	@Override
	public InventoryValidationDTO getAllSupplier(SupplierDTO supplierDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		List<SupplierDTO>  list = supplierRepository.getAlSupplierByClinicId(supplierDTO.getClinicId());
		if(list.size() > 0){
			inventoryValidationDTO.setSupplierDTOs(list);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
		}else{
			error.setError(Constant.INVALIDDATA);
			error.setMessage(Constant.INVALIDDATA);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			inventoryValidationDTO.setError(error);
			return inventoryValidationDTO;
			
		}
	}

	@Override
	public InventoryValidationDTO deleteSupplier(SupplierDTO supplierDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		 supplierRepository.deleteById(supplierDTO.getId());
		 inventoryValidationDTO = getAllSupplier(supplierDTO);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
	}

}
