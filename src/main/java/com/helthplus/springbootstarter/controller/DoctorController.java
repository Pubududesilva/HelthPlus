package com.helthplus.springbootstarter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.ResetPassword;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.DoctorService;
import com.helthplus.springbootstarter.services.EmailService;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService userService;
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/login_user")
	public ResponseEntity<UserValidationDTO> addUser(@RequestBody DoctorDTO dto){
		UserValidationDTO userDto = userService.loginUser(dto.getEmail(),dto.getPassword());
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}

	@PostMapping("/get_doctor_by_doctor_id")
	public ResponseEntity<UserValidationDTO> findUserById(@RequestBody DoctorDTO dto){
		UserValidationDTO userDto = userService.getUserById(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/adduserprofileimage")
	public ResponseEntity<UserValidationDTO> createUser(@RequestParam("imageFile") MultipartFile file){
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		UserValidationDTO userDto = new UserValidationDTO();
		userDto =  userService.uploadUserImage(file, Long.parseLong(file.getOriginalFilename()));
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getDoctorBySlmcNumber")
	public ResponseEntity<UserValidationDTO> findDoctorBySlmcNumber(@RequestBody DoctorDTO dto){
		UserValidationDTO userDto = userService.getDoctorBySLMCNumber(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/adddoctor")
	public ResponseEntity<UserValidationDTO> createUser(@RequestBody DoctorDTO dto){
		UserValidationDTO userDto = userService.createUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/get_all_doctor")
	public ResponseEntity<UserValidationDTO> getAllDoctor(){
		UserValidationDTO userDto = userService.getAllDoctor();
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/requestTokenForResetPassword")
	public ResponseEntity<UserValidationDTO> requestTokenForResetPassword(@RequestBody ResetPassword resetPassword){
		String email = resetPassword.getEmail();
		UserValidationDTO userDto = emailService.requestTokenForResetPasword(email);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
		
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<UserValidationDTO> resetPassword(@RequestBody ResetPassword resetPassword){
//		UserDTO dto = new UserDTO();
		String email = resetPassword.getEmail();
		String passWord  = resetPassword.getPassword();
		String token = resetPassword.getToken();
				
		UserValidationDTO userDto = emailService.resetPassword(email, passWord, token);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
		
	}
	
	
	
}
