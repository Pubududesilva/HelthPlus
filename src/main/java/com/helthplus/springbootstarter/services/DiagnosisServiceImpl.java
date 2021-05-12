package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.AllergyDTO;
import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.AllergyRepository;
import com.helthplus.springbootstarter.repositories.DiagnosisRepository;
import com.helthplus.springbootstarter.repositories.PatientRepository;

@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	DiagnosisRepository diagnosisRepo;
	
	@Autowired
	AllergyRepository allergyRepo;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public UserValidationDTO createDiagnosis(DiagnosisDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
//		dto.getPrescriptionDTO().setDrugIssue(false);
		DiagnosisDTO diagnosisDTO = new DiagnosisDTO();	
		if(dto.getId() > 0 ){
			dto.setUpdateDate(new Date());
			dto.getInvestigationDTO().setUpdateDate(new Date());
			dto.getFeeDTO().setUpdateDate(new Date());
			dto.getPrescriptionDTO().setUpdateDate(new Date());
		}else{
			dto.setCreateDate(new Date());
			dto.getInvestigationDTO().setCreateDate(new Date());
			dto.getFeeDTO().setCreateDate(new Date());
			dto.getPrescriptionDTO().setCreateDate(new Date());
			dto.getPrescriptionDTO().setDrugIssue(false);
		}
		if(dto.getPrescriptionDTO().getRedeemPrescribeDrugDTOs() != null &&  dto.getPrescriptionDTO().getRedeemPrescribeDrugDTOs().size() >0){
			dto.getPrescriptionDTO().setDrugIssue(true);
		}
			 diagnosisDTO =  diagnosisRepo.save(dto);


		List<DiagnosisDTO> dtosList = diagnosisRepo.findDiagnosisByPatientId(dto.getPatientId());
		
		if(diagnosisDTO != null){
			
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setDiagnosisDTOs(dtosList);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setDiagnosisDTOs(dtosList);
			return userValidationDTO;
		}

		
	}

	@Override
	public UserValidationDTO getDiagnosis(PatientDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<DiagnosisDTO> diagnosisList =	diagnosisRepo.findDiagnosisByPatientId(dto.getId());
		List<AllergyDTO> allergyList = allergyRepo.findByPatientId(dto.getId());
		List<PatientDTO> patientDTOs = new ArrayList<>();
		PatientDTO patientDTO = dto;
		patientDTOs.add(patientDTO);
		userValidationDTO.setDiagnosisDTOs(diagnosisList);
		userValidationDTO.setAllergyDTOs(allergyList);
		userValidationDTO.setPatientDTO(patientDTOs);
		return userValidationDTO;
	}

	@Override
	public UserValidationDTO getDiagnosisById(DiagnosisDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<DiagnosisDTO> diagnosisDTOs = new ArrayList<DiagnosisDTO>();
		DiagnosisDTO diagnosis = diagnosisRepo.findById(dto.getId());
		diagnosisDTOs.add(diagnosis);
		
		userValidationDTO.setDiagnosisDTOs(diagnosisDTOs);
		return userValidationDTO;
	}

}
