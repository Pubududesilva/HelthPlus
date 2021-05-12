package com.helthplus.springbootstarter.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.MedicineDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.MedicineRepository;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	MedicineRepository medicineRepository; 

	@Override
	public UserValidationDTO createMedicine(MedicineDTO medicineDTO) {
		MedicineDTO dto =  medicineRepository.save(medicineDTO);
		medicineDTO.setCreateDate(new Date());
		ErrorDTO errorDTO = new ErrorDTO();
		UserValidationDTO userValidationDTO = new UserValidationDTO();

		if(dto != null){
						userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
			
		}else{
			errorDTO.setError(Constant.SAVEFAILL);
			errorDTO.setMessage(Constant.SAVEFAILL);
			userValidationDTO.setError(errorDTO);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
			
			
		}
	}

}
