package com.helthplus.springbootstarter.services;


import java.util.List;

import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.exceptions.EtAuthException;

public interface PatientService {

	UserValidationDTO registerPatient(PatientDTO dto) ;
	
	UserValidationDTO getAllPatients() ;
	
	UserValidationDTO getAllPatientsByName(PatientDTO dto) ;
	
	UserValidationDTO getAllPatientsById(PatientDTO dto) ;

}
