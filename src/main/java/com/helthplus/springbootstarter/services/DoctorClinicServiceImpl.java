package com.helthplus.springbootstarter.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.common.JwtToken;
import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.EmailRequestDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.DoctorClinicRepository;

@Service
@Transactional
public class DoctorClinicServiceImpl implements DoctorClinicService {

	@Autowired
	DoctorClinicRepository doctorClinicRepository;   
	
	@Autowired
	EmailService emailService;
	
	@Override
	public UserValidationDTO addDoctorToClinic(DoctorClinicDTO doctorClinicDTO) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		doctorClinicDTO.setCreateDate(new Date());
		JwtToken jwtToken = new JwtToken();
//		int count =  doctorClinicRepository.findByDoctor(doctorClinicDTO.getClinicId(), doctorClinicDTO.getDoctorId());
		DoctorClinicDTO docClinicDTO =  doctorClinicRepository.findByDoctorByClinicId(doctorClinicDTO.getClinicId(), doctorClinicDTO.getDoctorId());
		String token = jwtToken.generateJWTTokenToUser(doctorClinicDTO);
		if(docClinicDTO == null ){
			doctorClinicRepository.save(doctorClinicDTO);
		}
		
		if(docClinicDTO != null && !docClinicDTO.isEmailVerify()){
			EmailRequestDTO emailRequestDTO = emailService.sendEmailToUser(doctorClinicDTO.getEmail(), docClinicDTO.getEmailKey(), doctorClinicDTO.getId());
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}
		
		if(docClinicDTO != null && docClinicDTO.isEmailVerify()){
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError(Constant.EMAILALREADYSEND);
			errorDTO.setMessage(Constant.EMAILALREADYSEND);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
		}
		
		
		doctorClinicDTO.setEmailKey(token);
//		EmailRequestDTO emailRequestDTO = emailService.sendEmailWithToken(doctorClinicDTO.getEmail(), token);
		EmailRequestDTO emailRequestDTO = emailService.sendEmailToUser(doctorClinicDTO.getEmail(), token, doctorClinicDTO.getId());
		DoctorClinicDTO clinicDTO =  doctorClinicRepository.save(doctorClinicDTO);
		if(clinicDTO != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}
	

}
