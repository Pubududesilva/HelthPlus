package com.helthplus.springbootstarter.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.repositories.MedicineBrandNameRepository;

@Service
@Transactional
public class MedicineBrandNameServiceImpl implements MedicineBrandNameService {
	
	@Autowired
	private MedicineBrandNameRepository medicineBrandNameRepository;

	@Override
	public InventoryValidationDTO createMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO) {
		medicineBrandNameDTO.setCreateDate(new Date());
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO errorDTO = new ErrorDTO();
		MedicineBrandNameDTO dto =  medicineBrandNameRepository.save(medicineBrandNameDTO);
		
		if(dto != null){
			List<MedicineBrandNameDTO>  list = medicineBrandNameRepository.getAlSupplierByClinicId(medicineBrandNameDTO.getClinicId());
			inventoryValidationDTO.setMedicineBrandNameDTOs(list);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
		}else{
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
		}
		
	}

	@Override
	public InventoryValidationDTO getAllMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		List<MedicineBrandNameDTO>  list = medicineBrandNameRepository.getAlSupplierByClinicId(medicineBrandNameDTO.getClinicId());
		if(list.size() > 0){
			inventoryValidationDTO.setMedicineBrandNameDTOs(list);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
		}else{
			error.setError(Constant.INVALIDBRANDNAME);
			error.setMessage(Constant.INVALIDBRANDNAME);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			inventoryValidationDTO.setError(error);
			return inventoryValidationDTO;
			
		}
	}

	@Override
	public InventoryValidationDTO deleteMedicineBrandName(MedicineBrandNameDTO medicineBrandNameDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		medicineBrandNameRepository.deleteById(medicineBrandNameDTO.getId());
		 inventoryValidationDTO = getAllMedicineBrandName(medicineBrandNameDTO);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
	}

}
