package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorIncomeByMonthly;
import com.helthplus.springbootstarter.domain.ReportValidation;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.DoctorIncomeMonthlyRepository;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class DoctorIncomeServiceImpl implements DoctorIncomeService  {
	
	@Autowired
	DoctorIncomeMonthlyRepository doctorIncomeMonthlyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicRepository clinicRepository;

	@Override
	public ReportValidation getDoctorIncomeReport(String uId,long clinicId, long doctorId, String fromDate,
			String toDate) {
		
		long userId = Long.parseLong(uId);
		UserDTO userDTO = userRepository.findById(userId);
		ClinicDTO clinicDTO = clinicRepository.findById(clinicId);
		ReportValidation reportValidation = new ReportValidation();
		List<DoctorIncomeByMonthly> doctorDtoList = new ArrayList<DoctorIncomeByMonthly>();
		
		if(!fromDate.equals("") && !toDate.equals("")){
			doctorDtoList = doctorIncomeMonthlyRepository.findByDoctorIncomeById(clinicId, doctorId,fromDate,toDate);
		}else{
			doctorDtoList = doctorIncomeMonthlyRepository.findByDoctorAllIncomeById(clinicId, doctorId);
		}
		
		reportValidation.setDoctorIncomeByMonthlies(doctorDtoList);
		reportValidation.setClinicDTO(clinicDTO);
		reportValidation.setUserDTO(userDTO);
		reportValidation.setHttpCode(200);
		reportValidation.setStatus(1);
		return reportValidation;
	}

}
