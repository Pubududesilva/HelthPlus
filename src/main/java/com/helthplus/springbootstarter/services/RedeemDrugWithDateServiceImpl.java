package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.RedeemDrugWithDate;
import com.helthplus.springbootstarter.domain.ReportValidation;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.RedeemDrugWithDateRepository;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class RedeemDrugWithDateServiceImpl implements RedeemDrugWithDateService {

	@Autowired
	RedeemDrugWithDateRepository redeemDrugWithDateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicRepository clinicRepository;
	
	@Override
	public ReportValidation getRedeemDrugByDate(long clinicId, String medicineId,String uId,String fromDate, String toDate) {
		List<RedeemDrugWithDate> redeemDrugWithDates = new ArrayList<RedeemDrugWithDate>();
		Long medicine = Long.parseLong(medicineId);
		long userId = Long.parseLong(uId);
		UserDTO userDTO = userRepository.findById(userId);
		ClinicDTO clinicDTO = clinicRepository.findById(clinicId);


		if(!fromDate.equals("") && !toDate.equals("")){
			
			if(medicineId.equals("888") ){	
				redeemDrugWithDates =  redeemDrugWithDateRepository.findRedeemDrugWithClinic(clinicId,fromDate,toDate);	
			}else
			redeemDrugWithDates =  redeemDrugWithDateRepository.findRedeemDrugMedicine(clinicId,medicine,fromDate,toDate);	
			
		}else{
			if(medicineId.equals("888") ){	
				redeemDrugWithDates =  redeemDrugWithDateRepository.findRedeemAllDrug(clinicId);	
			}else{
				redeemDrugWithDates =  redeemDrugWithDateRepository.findRedeemDrugHistory(clinicId,medicine);	
			}
			
		}
		

		


		ReportValidation reportValidation = new ReportValidation();
		ErrorDTO errorDTO = new ErrorDTO();
		if(redeemDrugWithDates.size() > 0){
			reportValidation.setHttpCode(200);
			reportValidation.setClinicDTO(clinicDTO);
			reportValidation.setUserDTO(userDTO);
			reportValidation.setStatus(1);
			reportValidation.setRedeemDrugWithDates(redeemDrugWithDates);
			return reportValidation;
		}else{
			reportValidation.setHttpCode(500);
			reportValidation.setStatus(0);
			errorDTO.setError(Constant.NODATAFOUND);
			errorDTO.setMessage(Constant.NODATAFOUND);
			reportValidation.setError(errorDTO);
			return reportValidation;
		}
	}

}
