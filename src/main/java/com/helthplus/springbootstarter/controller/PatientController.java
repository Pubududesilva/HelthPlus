package com.helthplus.springbootstarter.controller;

import java.util.List;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthplus.springbootstarter.domain.AllergyDTO;
import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.InvestigationDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.AllergyService;
import com.helthplus.springbootstarter.services.DiagnosisService;
import com.helthplus.springbootstarter.services.InvestigationService;
import com.helthplus.springbootstarter.services.PatientService;

@RestController
@RequestMapping("api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	DiagnosisService diagnosisService;
	
	@Autowired
	AllergyService allergyService; 
	
	@Autowired
	InvestigationService investigationService; 
	
	@PostMapping("/registerpatient")
	public ResponseEntity<UserValidationDTO> addUser(@RequestBody PatientDTO dto){
		UserValidationDTO userDto = patientService.registerPatient(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	
	@PostMapping("/getallpatients")
	public ResponseEntity<UserValidationDTO> getAllPatients(){
		UserValidationDTO userDto = patientService.getAllPatients();
		return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getpatientsbyname")
	public ResponseEntity<UserValidationDTO> getPatientsByName(@RequestBody PatientDTO dto){
		UserValidationDTO userDto = patientService.getAllPatientsByName(dto);
		return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getpatientsbyid")
	public ResponseEntity<UserValidationDTO> getPatientsById(@RequestBody PatientDTO dto){
		UserValidationDTO userDto = patientService.getAllPatientsById(dto);
		return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}

	
	@PostMapping("/creatediagnosis")
	public ResponseEntity<DiagnosisDTO> createPrescription(@RequestBody DiagnosisDTO dto){
		System.out.println("Create Diagnosis...");
		diagnosisService.createDiagnosis(dto);
		return new ResponseEntity<DiagnosisDTO>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/getdiagnosisbypatientid")
	public ResponseEntity<UserValidationDTO> getPrescription(@RequestBody PatientDTO dto){
		UserValidationDTO diagnosisDTO = diagnosisService.getDiagnosis(dto);
		return new ResponseEntity<UserValidationDTO>(diagnosisDTO,HttpStatus.OK);
	}
	
	@PostMapping("/getdiagnosisbyid")
	public ResponseEntity<UserValidationDTO> getDiagnosisById(@RequestBody DiagnosisDTO dto){
		UserValidationDTO diagnosisDTO = diagnosisService.getDiagnosisById(dto);
		return new ResponseEntity<UserValidationDTO>(diagnosisDTO,HttpStatus.OK);
	}
	
	@PostMapping("/getdiagnosisbypatientdetailsbyid")
	public ResponseEntity<UserValidationDTO> getDiagnosisPatientDetailsById(@RequestBody PatientDTO dto){
		UserValidationDTO diagnosisDTO = diagnosisService.getDiagnosis(dto);
		return new ResponseEntity<UserValidationDTO>(diagnosisDTO,HttpStatus.OK);
	}
	
	@PostMapping("/createallergybypatientid")
	public ResponseEntity<UserValidationDTO> createAllergyBypatient(@RequestBody AllergyDTO dto){
		UserValidationDTO diagnosisDTO = allergyService.createAllergyByPatientId(dto);
		return new ResponseEntity<UserValidationDTO>(diagnosisDTO,HttpStatus.OK);
	}
	
	@PostMapping("/getallergybypatientid")
	public ResponseEntity<UserValidationDTO> getAllergyBypatient(@RequestBody PatientDTO dto){
		UserValidationDTO diagnosisDTO = allergyService.getAllergiesByPatinetId(dto);
		return new ResponseEntity<UserValidationDTO>(diagnosisDTO,HttpStatus.OK);
	}
	
	@PostMapping("/updateinvestigationbyid")
	public ResponseEntity<UserValidationDTO> getAllergyBypatient(@RequestBody InvestigationDTO listInvestigationDTOs){
		UserValidationDTO userValidationDTO = investigationService.createAllergyByPatientId(listInvestigationDTOs);
		return new ResponseEntity<UserValidationDTO>(userValidationDTO,HttpStatus.OK);
	}
	
}
