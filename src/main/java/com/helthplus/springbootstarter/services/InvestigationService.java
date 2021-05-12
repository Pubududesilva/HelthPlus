package com.helthplus.springbootstarter.services;

import java.util.List;

import com.helthplus.springbootstarter.domain.AllergyDTO;
import com.helthplus.springbootstarter.domain.InvestigationDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface InvestigationService {
	
	UserValidationDTO createAllergyByPatientId(InvestigationDTO  dto);

}
