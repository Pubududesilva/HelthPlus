package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface ClinicService {
	
	UserValidationDTO createClinic(ClinicDTO clinicDTO);
	
	UserValidationDTO getClinicById(ClinicDTO clinicDTO);
	

}
