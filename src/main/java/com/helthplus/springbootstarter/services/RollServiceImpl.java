package com.helthplus.springbootstarter.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.RollDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.RollRepository;

@Service
@Transactional
public class RollServiceImpl implements RollService {

	@Autowired
	RollRepository rollRepository;
	
	@Override
	public UserValidationDTO createRoll(RollDTO rollDTO) {
		RollDTO dto =  rollRepository.save(rollDTO);
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		if(dto != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}



}
