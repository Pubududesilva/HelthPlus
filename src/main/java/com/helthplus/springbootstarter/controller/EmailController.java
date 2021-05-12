package com.helthplus.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.EmailService;

@RestController
@RequestMapping("api/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/conformclinic/{email}")
	public String verifyEmail(@PathVariable(value = "email",required = true) String email)
	{
		String value = email;
		emailService.verifyEmailConformation(email);
		 return "<h1>Email Conformed.</h1>";
	}
	
	@GetMapping("/verifydoctoremail/{email}")
	public String verifyDoctorEmail(@PathVariable(value = "email",required = true) String email)
	{
		String value = email;
		 emailService.verifyDoctorEmailConformation(email);
		 return "<h1>Email Conformed.</h1>";
	}

}
