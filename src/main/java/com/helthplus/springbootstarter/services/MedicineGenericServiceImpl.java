package com.helthplus.springbootstarter.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.MedicineGenericNameDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.MedicineGenericRepository;

@Service
@Transactional
public class MedicineGenericServiceImpl implements MedicineGenericService{

	@Autowired
	MedicineGenericRepository medicineGenericRepository;
	
	@Override
	public UserValidationDTO createMedicineGeneric(MedicineGenericNameDTO genericNameDTO) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		genericNameDTO.setCreateDate(new Date());
		MedicineGenericNameDTO medicineGenericNameDTO = medicineGenericRepository.save(genericNameDTO);
		if(medicineGenericNameDTO != null){
			List<MedicineGenericNameDTO>  genericNameDTOs = medicineGenericRepository.getAllMedicineGenericByClinicId(genericNameDTO.getClinicId());
			userValidationDTO.setListMedicineGenericNameDTO(genericNameDTOs);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}else{
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError(Constant.SAVEFAILL);
			errorDTO.setMessage(Constant.SAVEFAILL);
			userValidationDTO.setError(errorDTO);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
			
		}
	}

	@Override
	public UserValidationDTO getAllMedicineGenericByClinicId(MedicineGenericNameDTO genericNameDTO) {
		List<MedicineGenericNameDTO>  genericNameDTOs = medicineGenericRepository.getAllMedicineGenericByClinicId(genericNameDTO.getClinicId());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		userValidationDTO.setListMedicineGenericNameDTO(genericNameDTOs);
		userValidationDTO.setHttpCode(200);
		userValidationDTO.setStatus(1);
		return userValidationDTO;
	}

	@Override
	public UserValidationDTO deleteMedicineGenericById(MedicineGenericNameDTO genericNameDTO) {
		medicineGenericRepository.deleteById(genericNameDTO.getId());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<MedicineGenericNameDTO>  genericNameDTOs = medicineGenericRepository.getAllMedicineGenericByClinicId(genericNameDTO.getClinicId());
		userValidationDTO.setListMedicineGenericNameDTO(genericNameDTOs);
		userValidationDTO.setHttpCode(200);
		userValidationDTO.setStatus(1);
		return userValidationDTO;
	}

}
