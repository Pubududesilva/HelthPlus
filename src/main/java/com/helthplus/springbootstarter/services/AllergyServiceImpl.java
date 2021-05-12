package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.AllergyDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.AllergyRepository;

@Service
@Transactional
public class AllergyServiceImpl implements AllergyService  {
	
	@Autowired
	AllergyRepository allergyRepo;

	@Override
	public UserValidationDTO createAllergyByPatientId(AllergyDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		dto.setCreateDate(new Date());
		dto.setCreateDate(new Date());
		AllergyDTO allergyDTO = allergyRepo.save(dto);
		List<AllergyDTO> allergyDTOs =  allergyRepo.findByPatientId(dto.getPatientId());
		if(allergyDTO != null){
			List<AllergyDTO> list = new ArrayList<AllergyDTO>();
			list.add(allergyDTO);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setAllergyDTOs(allergyDTOs);
			return userValidationDTO;
		}else{
			userValidationDTO.setStatus(0);
			userValidationDTO.setHttpCode(500);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO getAllergiesByPatinetId(PatientDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<AllergyDTO> allergyDTOs =  allergyRepo.findByPatientId(dto.getId());
		userValidationDTO.setHttpCode(200);
		userValidationDTO.setStatus(1);
		userValidationDTO.setAllergyDTOs(allergyDTOs);
		return userValidationDTO;
	}

}
