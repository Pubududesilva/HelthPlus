package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface DoctorClinicService {
	
	UserValidationDTO addDoctorToClinic(DoctorClinicDTO doctorClinicDTO);

}
