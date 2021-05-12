package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.LedgerIncomeDTO;
import com.helthplus.springbootstarter.domain.ReportValidation;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.LedgerIncomeRepository;
import com.helthplus.springbootstarter.repositories.RedeemDrugWithDateRepository;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class LedgerIncomeServiceImpl implements LedgerIncomeService {
	

	@Autowired
	LedgerIncomeRepository ledgerIncomeRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicRepository clinicRepository;

	@Override
	public ReportValidation getLedgerIncomeByDateRange(long clinicId, long doctorId, String uId, String fromDate,
			String toDate) {
		
		List<LedgerIncomeDTO> ledgerIncomeDTOs = new ArrayList<LedgerIncomeDTO>();
		long userId = Long.parseLong(uId);
		UserDTO userDTO = userRepository.findById(userId);
		ClinicDTO clinicDTO = clinicRepository.findById(clinicId);
		ReportValidation reportValidation = new ReportValidation();
		
		if(!fromDate.equals("") && !toDate.equals("")){
			ledgerIncomeDTOs = ledgerIncomeRepository.findLedgerIncomeWithDateRange(clinicId, doctorId, fromDate, toDate);
		}else{
			ledgerIncomeDTOs = ledgerIncomeRepository.findLedgerIncome(clinicId, doctorId);
		}
		reportValidation.setClinicDTO(clinicDTO);
		reportValidation.setLedgerIncomeDTOs(ledgerIncomeDTOs);
		reportValidation.setUserDTO(userDTO);
		reportValidation.setHttpCode(200);
		reportValidation.setStatus(1);
		return reportValidation;
	}

	@Override
	public ReportValidation getLedgerIncomeInDetail(long clinicId, long doctorId, String uId, String fromDate,
			String toDate) {
		List<LedgerIncomeDTO> ledgerIncomeDTOs = new ArrayList<LedgerIncomeDTO>();
		long userId = Long.parseLong(uId);
		UserDTO userDTO = userRepository.findById(userId);
		ClinicDTO clinicDTO = clinicRepository.findById(clinicId);
		ReportValidation reportValidation = new ReportValidation();
		
		if(!fromDate.equals("") && !toDate.equals("")){
			ledgerIncomeDTOs = ledgerIncomeRepository.findLedgerIncomeDetailsWithDateRange(clinicId, doctorId, fromDate, toDate);
		}else{
			ledgerIncomeDTOs = ledgerIncomeRepository.findLedgerIncomeDetails(clinicId, doctorId);
		}
		reportValidation.setClinicDTO(clinicDTO);
		reportValidation.setLedgerIncomeDTOs(ledgerIncomeDTOs);
		reportValidation.setUserDTO(userDTO);
		reportValidation.setHttpCode(200);
		reportValidation.setStatus(1);
		return reportValidation;
	}

}
