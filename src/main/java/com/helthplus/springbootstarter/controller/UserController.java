package com.helthplus.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	
	@Autowired
	UserService userService; 
	
	
	@PostMapping("/loginuser")
	public ResponseEntity<UserValidationDTO> loginClinicUser(@RequestBody UserDTO dto){
		UserValidationDTO userDto = userService.loginUser(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}

}
