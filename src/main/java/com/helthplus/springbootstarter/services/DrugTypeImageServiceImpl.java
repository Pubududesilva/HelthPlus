package com.helthplus.springbootstarter.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.DrugTypeImageDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.repositories.DrugTypeImageRepository;

@Service
@Transactional
public class DrugTypeImageServiceImpl implements DrugTypeImageService {
	
	@Autowired
	DrugTypeImageRepository drugTypeImageRepository;

	@Override
	public InventoryValidationDTO getAllDrugTypeImage() {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		List<DrugTypeImageDTO> drugTypeImageDTOs =  drugTypeImageRepository.getAlDrugTypeImageDTOClinicId();
		
		inventoryValidationDTO.setDrugTypeImageDTOs(drugTypeImageDTOs);
		return inventoryValidationDTO;
	}

	@Override
	public InventoryValidationDTO createTypeImage(DrugTypeImageDTO dto) {
		drugTypeImageRepository.save(dto);
		return null;
	}

}
