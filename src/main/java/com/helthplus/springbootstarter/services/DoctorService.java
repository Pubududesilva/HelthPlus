package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.PatientDTO;

import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface DoctorService {
	
	UserValidationDTO loginUser(String email,String password) ;
	
	UserValidationDTO getUserById(DoctorDTO dto) ;
	
	UserValidationDTO getDoctorBySLMCNumber(DoctorDTO dto) ;
	
	UserValidationDTO createUser(DoctorDTO dto) ;
	
	UserValidationDTO getAllDoctor();
	
	UserValidationDTO uploadUserImage(MultipartFile file,Long userId );

}
