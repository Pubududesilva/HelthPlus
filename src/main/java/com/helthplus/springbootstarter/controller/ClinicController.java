package com.helthplus.springbootstarter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.RollDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.ClinicService;
import com.helthplus.springbootstarter.services.DoctorClinicService;
import com.helthplus.springbootstarter.services.RollService;
import com.helthplus.springbootstarter.services.UserService;

@RestController
@RequestMapping("api/clinic")
public class ClinicController {
	
	@Autowired
	ClinicService clinicService; 
	
	@Autowired
	UserService userService; 
	
	@Autowired
	RollService rollService; 
	

	@Autowired
	HttpServletRequest httpRequest;

	
	@Autowired
	DoctorClinicService doctorClinicService;
	
	@PostMapping("/addclinic")
	public ResponseEntity<UserValidationDTO> createUser(@RequestBody ClinicDTO dto){
		UserValidationDTO userDto = clinicService.createClinic(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getclinicbyid")
	public ResponseEntity<UserValidationDTO> getClinicById(@RequestBody ClinicDTO dto){
		UserValidationDTO userDto = clinicService.getClinicById(dto);
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

	@PostMapping("/adduser")
	public ResponseEntity<UserValidationDTO> createUser(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.createUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deleteuser")
	public ResponseEntity<UserValidationDTO> deleteUser(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.deleteClinicUserById(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/addroll")
	public ResponseEntity<UserValidationDTO> createRoll(@RequestBody RollDTO dto){
		UserValidationDTO userDto = rollService.createRoll(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}

	
	@PostMapping("/getclinicuserbyid")
	public ResponseEntity<UserValidationDTO> getClinicUserById(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.getClinicUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getsystemdoctorsbyclinicid")
	public ResponseEntity<UserValidationDTO> getSystemDoctorsByClinicId(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.getClinicUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getallsystemuserbyclinicid")
	public ResponseEntity<UserValidationDTO> getAllSystemUserByClinicId(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.getAllClinicUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getsystemuserbyid")
	public ResponseEntity<UserValidationDTO> getSystemUserById(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.getSystemUserById(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/adddoctortoclinic")
	public ResponseEntity<UserValidationDTO> addDoctorToClinic(@RequestBody DoctorClinicDTO dto){
		UserValidationDTO userDto = doctorClinicService.addDoctorToClinic(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createsystemuser")
	public ResponseEntity<UserValidationDTO> createSystemUser(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.createSystemUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
}
