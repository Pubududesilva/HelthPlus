package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.AllergyDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface AllergyService {
	
	UserValidationDTO createAllergyByPatientId(AllergyDTO dto);
	
	UserValidationDTO getAllergiesByPatinetId(PatientDTO dto);

}
