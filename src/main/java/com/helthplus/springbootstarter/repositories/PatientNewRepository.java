package com.helthplus.springbootstarter.repositories;

import java.util.Date;
import java.util.List;

import com.helthplus.springbootstarter.domain.PatientDTO;

public interface PatientNewRepository {
	
	 List<PatientDTO> findPatientDetailsByUserFirstName( String firstName,String lastName,Date dob, String doctorSlmc) ;


}
