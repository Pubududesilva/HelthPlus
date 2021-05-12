package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface DiagnosisService {
	
	UserValidationDTO createDiagnosis(DiagnosisDTO dto);
	
	UserValidationDTO getDiagnosis(PatientDTO dto);
	
	UserValidationDTO getDiagnosisById(DiagnosisDTO dto);

}
