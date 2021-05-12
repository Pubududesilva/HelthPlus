package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DailyIncomeDTO;
import com.helthplus.springbootstarter.domain.ReportValidation;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.DailyIncomeReporitory;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class DailyIncomeServiceImpl implements DailyIncomeService {
	
	@Autowired
	DailyIncomeReporitory dailyIncomeReporitory; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicRepository clinicRepository;

	@Override
	public ReportValidation getDailyIncomeByDateRange(long clinicId, long doctorId, String uId, String fromDate,
			String toDate) {
		
		List<DailyIncomeDTO> dailyIncomeDTOs = new ArrayList<DailyIncomeDTO>();
		long userId = Long.parseLong(uId);
		UserDTO userDTO = userRepository.findById(userId);
		ClinicDTO clinicDTO = clinicRepository.findById(clinicId);
		ReportValidation reportValidation = new ReportValidation();
		
		if(!fromDate.equals("") && !toDate.equals("")){
			dailyIncomeDTOs = dailyIncomeReporitory.findDailyIncomeWithDateRange(clinicId, doctorId, fromDate, toDate);
		}else{
			dailyIncomeDTOs = dailyIncomeReporitory.findDailyIncomeByDoctorId(clinicId, doctorId);
		}
		reportValidation.setClinicDTO(clinicDTO);
		reportValidation.setDailyIncomeDTOs(dailyIncomeDTOs);
		reportValidation.setUserDTO(userDTO);
		reportValidation.setHttpCode(200);
		reportValidation.setStatus(1);
		return reportValidation;
	}



}
