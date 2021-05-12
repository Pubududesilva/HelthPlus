package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DrugBalanceDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.DrugBalanceRepository;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class DrugBalanceServiceImpl implements DrugBalanceService {

	@Autowired
	DrugBalanceRepository drugBalanceRepository;
	
	@Autowired
	ClinicRepository clinicRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public InventoryValidationDTO getDrugById(MedicineBrandNameDTO brandNameDTO) {
		InventoryValidationDTO dto = new InventoryValidationDTO();
		List<DrugBalanceDTO>  balanceDTO  = new ArrayList<>();
		Long settingId =  brandNameDTO.getMedicineBrandSettingId();
		
		if(settingId == 888  ){			
			balanceDTO =  drugBalanceRepository.findByClinicId(brandNameDTO.getClinicId());

			
		}else{
			balanceDTO =  drugBalanceRepository.findByBrandId(brandNameDTO.getMedicineBrandSettingId(),brandNameDTO.getClinicId());
		}

		List<DrugBalanceDTO>  listDrug = new ArrayList<DrugBalanceDTO>();
		UserDTO userDTO = userRepository.findById(brandNameDTO.getUserId());
		ClinicDTO clinicDTO = clinicRepository.findById(brandNameDTO.getClinicId());
//		listDrug.add(balanceDTO);
		dto.setBalanceDTOs(balanceDTO);
		dto.setUserDTO(userDTO);
		dto.setClinicDTO(clinicDTO);
		return dto;
	}

	@Override
	public InventoryValidationDTO getAllDrugByClinicId(MedicineBrandSettingDTO brandSettingDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
