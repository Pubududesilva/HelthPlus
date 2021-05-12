package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.JwtToken;
import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.PrescribeDrugDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.DiagnosisRepository;
import com.helthplus.springbootstarter.repositories.DoctorClinicRepository;
import com.helthplus.springbootstarter.repositories.PatientRepository;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DiagnosisRepository diagnosisRepository;
	
	@Autowired
	DoctorClinicRepository doctorClinicRepository;
	
	@Override
	public UserValidationDTO registerPatient(PatientDTO dto)  {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		dto.setCreatedDate(new Date());
		JwtToken jwtToken = new JwtToken();
		
		PatientDTO patientDTO = patientRepository.save(dto);
		if(patientDTO != null){
			List<PatientDTO> patientDTOList = new ArrayList();
			patientDTOList.add(patientDTO);
			userValidationDTO.setPatientDTO(patientDTOList);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}else{
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError("Saved Failed");
			errorDTO.setMessage("Invalid data");
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO getAllPatients() {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<PatientDTO> patientDTOs = (List<PatientDTO>) patientRepository.findAll();
		userValidationDTO.setPatientDTO(patientDTOs);
		return userValidationDTO;
	}

	@Override
	public UserValidationDTO getAllPatientsByName(PatientDTO dto) {
		String firstName = dto.getFirstName().trim();
		String lastName = dto.getLastName().trim();
		Date dob = dto.getDateOfBirth();
		List<PatientDTO> listPatientDto = new ArrayList<>();
		
		if(dto.getDoctorSlmc() != ""){
			if(firstName != "" && lastName != "" && dto.getDateOfBirth() != null){
				listPatientDto = patientRepository.findPatientDetailsByNameAndDOB(dto.getDoctorSlmc(), dto.getFirstName(), dto.getLastName() ,dto.getDateOfBirth());
				
			}else if(firstName != "" && lastName != "" ){
				 listPatientDto = patientRepository.findPatientDetailsByFirstNameANDLastName(dto.getDoctorSlmc(), dto.getFirstName(), dto.getLastName() );
			}
			else if(firstName != "" && dto.getDateOfBirth() != null ){
				 listPatientDto = patientRepository.findPatientDetailsFirstNameAndDOB(dto.getDoctorSlmc(), dto.getFirstName(),dto.getDateOfBirth());
			}
			else if(firstName != "" ){
				 listPatientDto = patientRepository.findPatientDetailsByFirstName(dto.getDoctorSlmc(), dto.getFirstName());
			}
			else if(lastName != "") {
				listPatientDto = patientRepository.findPatientDetailsByLastName(dto.getDoctorSlmc(), dto.getLastName() );
				
			}
			else if( dto.getDateOfBirth() != null){
				listPatientDto = patientRepository.findPatientDetailsByUserDOB(dto.getDoctorSlmc(), dto.getDateOfBirth());
				
			}else{
				listPatientDto = patientRepository.findByDoctorSlmc(dto.getDoctorSlmc());
			}
		}else{
//				listPatientDto = patientRepository.findPatientDetailsByClinicANDFName(dto.getFirstName());

			List<DoctorClinicDTO> list =  doctorClinicRepository.findDoctorByClinicId(dto.getClinicId());
			List<PatientDTO> listPatients = new ArrayList<>();
			
			for(DoctorClinicDTO clinicDTO : list){
				
				if(firstName != "" && lastName != "" && dto.getDateOfBirth() != null){
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsByFirstName(clinicDTO.getSlmc(), dto.getFirstName());
					listPatientDto.addAll(listPDto);
				}else if(firstName != "" && lastName != "" ){
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsByFirstNameANDLastName(clinicDTO.getSlmc(), dto.getFirstName(), dto.getLastName() );
					listPatientDto.addAll(listPDto);
				}else if(firstName != "" && dto.getDateOfBirth() != null ){
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsFirstNameAndDOB(clinicDTO.getSlmc(), dto.getFirstName(),dto.getDateOfBirth());
					listPatientDto.addAll(listPDto);
				}else if(firstName != "" ){
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsByFirstName(clinicDTO.getSlmc(), dto.getFirstName());
					listPatientDto.addAll(listPDto);
				}else if(lastName != "") {
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsByLastName(clinicDTO.getSlmc(), dto.getLastName() );
					listPatientDto.addAll(listPDto);
					
				}else if( dto.getDateOfBirth() != null){
					List<PatientDTO> listPDto = patientRepository.findPatientDetailsByUserDOB(clinicDTO.getSlmc(), dto.getDateOfBirth());
					listPatientDto.addAll(listPDto);
				}else{
					List<PatientDTO> listPDto = patientRepository.findByDoctorSlmc(clinicDTO.getSlmc());
					listPatientDto.addAll(listPDto);
				}

			}
			
			
		}
		
//		List<PatientDTO> listPatientDto = patientRepository.findPatientByUserName(dto.getFirstName(), dto.getLastName());
//		 listPatientDto = patientRepository.findPatientDetailsByUserFirstNamex(dto.getDoctorSlmc(), dto.getFirstName(), dto.getLastName() ,dto.getDateOfBirth());

		UserValidationDTO userValidationDTO = new UserValidationDTO();
		if(listPatientDto.size() > 0){
			
			for(PatientDTO p : listPatientDto){
				Date d = new Date();
//				d = p.getDateOfBirth();
//				p.setDateOfBirth(d);
//				int c = 10;

				
			}
			userValidationDTO.setPatientDTO(listPatientDto);
			userValidationDTO.setStatus(1);
			userValidationDTO.setHttpCode(200);
			return userValidationDTO;
		}else{
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError("No Data Found");
			userValidationDTO.setError(errorDTO);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO getAllPatientsById(PatientDTO dto) {
		List<PatientDTO> patientDtoList = patientRepository.findPatientByUserId(dto.getId());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<PatientDTO> listPatientDto = new  ArrayList<PatientDTO>();
		if(patientDtoList.size() > 0 ){
			userValidationDTO.setPatientDTO(patientDtoList);
			userValidationDTO.setStatus(1);
			userValidationDTO.setHttpCode(200);
			return userValidationDTO;
		}else{
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError("No Data Found");
			userValidationDTO.setError(errorDTO);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}




}
