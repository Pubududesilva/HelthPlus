package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.EmailRequestDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface EmailService {
//	String sendEmail(String email,String token,Integer userId);
	
	EmailRequestDTO sendEmail(String email,String token,Long userId);
	
	EmailRequestDTO sendEmailToUser(String email,String token,Long userId);
	
	EmailRequestDTO sendEmailWithToken(String email,String token);
	
	String sendEmail1(String email);
	
	UserValidationDTO validateUserConformation(String token);
	
	UserValidationDTO validateDoctorConformation(String token);
	
	UserValidationDTO verifyEmailConformation(String token);
	
	UserValidationDTO verifyDoctorEmailConformation(String token);
	
	UserValidationDTO requestTokenForResetPasword(String email);
	
	UserValidationDTO resetPassword(String email,String newPassword,String token);
	
	UserValidationDTO resetPassword(DoctorDTO dto);
	
	boolean validateEmailAddress(String email);
	
//	Mail prepareEmail(String email);

}
