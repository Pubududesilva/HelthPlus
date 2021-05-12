package com.helthplus.springbootstarter.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.InvestigationDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.InvestigationRepo;

import net.bytebuddy.asm.Advice.Return;

@Service
@Transactional
public class InvestigationServiceImpl implements InvestigationService{

	@Autowired
	private InvestigationRepo investigationRepo;
	
	
	@Override
	public UserValidationDTO createAllergyByPatientId(InvestigationDTO investigationDTOs) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		
//		for(InvestigationDTO dto: investigationDTOs){
//			System.out.println("Des "+dto.getInvestgationDescription());
//			System.out.println("Res "+dto.getInvestgationResult());
			investigationRepo.save(investigationDTOs);
			
			

//		}
//		List<InvestigationDTO> listInvestigation = (List<InvestigationDTO>) investigationRepo.saveAll(dto);
//		if(listInvestigation.size()>0){
//			userValidationDTO.setHttpCode(200);
//			userValidationDTO.setStatus(1);
//			return userValidationDTO;
//		}else{
//			userValidationDTO.setHttpCode(500);
//			userValidationDTO.setStatus(0);
//			return userValidationDTO;
//		}
		return userValidationDTO;
	}
	

}
