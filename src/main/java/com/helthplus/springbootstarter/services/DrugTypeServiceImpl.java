package com.helthplus.springbootstarter.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.DrugTypeDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;
import com.helthplus.springbootstarter.repositories.DrugTypeRepository;

@Service
@Transactional
public class DrugTypeServiceImpl implements DrugTypeService{

	@Autowired
	DrugTypeRepository drugTypeRepository;
	
	@Override
	public InventoryValidationDTO createDrugType(DrugTypeDTO drugTypeDTO) {
		drugTypeDTO.setCreateDate(new Date());
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO errorDTO = new ErrorDTO();
		int count = drugTypeRepository.getDrugType(drugTypeDTO.getType(),drugTypeDTO.getClinicId());
		if(count > 0){
			errorDTO.setError(Constant.DRUG_TYPE_IS_AVAILABLE);
			errorDTO.setMessage(Constant.DRUG_TYPE_IS_AVAILABLE);
			inventoryValidationDTO.setError(errorDTO);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
			
		}
		
		DrugTypeDTO supplietDto =  drugTypeRepository.save(drugTypeDTO);

		if(supplietDto != null){
			return getAllDrugType(drugTypeDTO);
		}else{
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
		}
	}

	@Override
	public InventoryValidationDTO getAllDrugType(DrugTypeDTO drugTypeDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		List<DrugTypeDTO>  list = drugTypeRepository.getAlDrugTypeByClinicId(drugTypeDTO.getClinicId());
		if(list.size() > 0){
			inventoryValidationDTO.setDrugTypeDTOs(list);
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
	public InventoryValidationDTO deleteDrugType(DrugTypeDTO drugTypeDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		 drugTypeRepository.deleteById(drugTypeDTO.getId());
		 inventoryValidationDTO = getAllDrugType(drugTypeDTO);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
	}

}
