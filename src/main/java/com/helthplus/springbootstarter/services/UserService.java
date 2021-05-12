package com.helthplus.springbootstarter.services;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.domain.RollDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface UserService {
	
	UserValidationDTO createUser(UserDTO userDTO);
	
	UserValidationDTO loginUser(UserDTO userDTO);
	
	UserValidationDTO getClinicUser(UserDTO userDTO);
	
	UserValidationDTO getAllClinicUser(UserDTO userDTO);
	
	UserValidationDTO deleteClinicUserById(UserDTO userDTO);
	
	UserValidationDTO getSystemDoctorsByClinicId(UserDTO userDTO);
	
	UserValidationDTO getSystemUserById(UserDTO userDTO);
	
	
	UserValidationDTO createSystemUser(UserDTO userDTO);
	
	UserValidationDTO uploadUserImage(MultipartFile file,Long userId );

}
