package com.helthplus.springbootstarter.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;

@Service
@Transactional
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	ClinicRepository clinicRepository; 

	@Override
	public UserValidationDTO createClinic(ClinicDTO clinicDTO) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		ClinicDTO dto = clinicRepository.save(clinicDTO);
		if(dto != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setClinicDTO(dto);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO getClinicById(ClinicDTO clinicDTO) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		ClinicDTO dto = clinicRepository.findById(clinicDTO.getId());
		if(dto != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setClinicDTO(dto);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

}
