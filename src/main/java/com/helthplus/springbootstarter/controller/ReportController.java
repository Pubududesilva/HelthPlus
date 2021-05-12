package com.helthplus.springbootstarter.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthplus.springbootstarter.domain.DrugBalanceDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.MedicineGenericNameDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.ReportValidation;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.services.DailyIncomeService;
import com.helthplus.springbootstarter.services.DoctorIncomeService;
import com.helthplus.springbootstarter.services.DrugBalanceService;
import com.helthplus.springbootstarter.services.LedgerIncomeService;
import com.helthplus.springbootstarter.services.RedeemDrugWithDateService;

@RestController
@RequestMapping("api/report")
public class ReportController {
	
	@Autowired
	DrugBalanceService drugBalanceService;
	
	@Autowired
	RedeemDrugWithDateService redeemDrugWithDateService; 
	
	@Autowired
	LedgerIncomeService ledgerIncomeService;
	
	@Autowired
	DailyIncomeService dailyIncomeService;
	
	@Autowired
	DoctorIncomeService doctorIncomeService;
	
	@PostMapping("/getdrugbalancebybrandid")
	public ResponseEntity<InventoryValidationDTO> createGenericName(@RequestBody MedicineBrandNameDTO  dto){
		InventoryValidationDTO userDto = drugBalanceService.getDrugById(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getRedeemDrugByDate")
	public ResponseEntity<ReportValidation> getRedeemDrugByDate(@RequestBody Map<String,Object> userMap){
		Long clinicId = Long.parseLong(userMap.get("clinicId").toString()) ;

		String from = userMap.get("fromDate").toString();
		String to = userMap.get("toDate").toString();
		String medicineId = userMap.get("medicineId").toString();
		String userId = userMap.get("userId").toString();
		 ReportValidation reportValidation = redeemDrugWithDateService.getRedeemDrugByDate(clinicId,medicineId,userId, from, to);
		 return new ResponseEntity<ReportValidation>(reportValidation,HttpStatus.OK);
	}
	
	
	@PostMapping("/getLedgerIncomeByDateRange")
	public ResponseEntity<ReportValidation> getLedgerIncomeByDateRange(@RequestBody Map<String,Object> userMap){
		Long clinicId = Long.parseLong(userMap.get("clinicId").toString()) ;
		Long doctorId = Long.parseLong(userMap.get("doctorId").toString()) ;
		String from = userMap.get("fromDate").toString();
		String to = userMap.get("toDate").toString();
		String userId = userMap.get("userId").toString();
		 ReportValidation reportValidation = ledgerIncomeService.getLedgerIncomeByDateRange(clinicId, doctorId, userId, from, to);
		 return new ResponseEntity<ReportValidation>(reportValidation,HttpStatus.OK);
	}
	
	@PostMapping("/getLedgerIncomeDetailsByDateRange")
	public ResponseEntity<ReportValidation> getLedgerIncomeDetailsByDateRange(@RequestBody Map<String,Object> userMap){
		Long clinicId = Long.parseLong(userMap.get("clinicId").toString()) ;
		Long doctorId = Long.parseLong(userMap.get("doctorId").toString()) ;
		String from = userMap.get("fromDate").toString();
		String to = userMap.get("toDate").toString();
		String userId = userMap.get("userId").toString();
		 ReportValidation reportValidation = ledgerIncomeService.getLedgerIncomeInDetail(clinicId, doctorId, userId, from, to);
		 return new ResponseEntity<ReportValidation>(reportValidation,HttpStatus.OK);
	}
	
	
	@PostMapping("/getDailyIncomeByDateRange")
	public ResponseEntity<ReportValidation> getDailyIncomeByDateRange(@RequestBody Map<String,Object> userMap){
		Long clinicId = Long.parseLong(userMap.get("clinicId").toString()) ;
		Long doctorId = Long.parseLong(userMap.get("doctorId").toString()) ;
		String from = userMap.get("fromDate").toString();
		String to = userMap.get("toDate").toString();
		String userId = userMap.get("userId").toString();
		 ReportValidation reportValidation = dailyIncomeService.getDailyIncomeByDateRange(clinicId, doctorId, userId, from, to);
		 return new ResponseEntity<ReportValidation>(reportValidation,HttpStatus.OK);
	}
	
	
	@PostMapping("/getDoctorIncomeByMonthly")
	public ResponseEntity<ReportValidation> getDoctorIncomeByMonthly(@RequestBody Map<String,Object> userMap){
		Long clinicId = Long.parseLong(userMap.get("clinicId").toString()) ;
		Long doctorId = Long.parseLong(userMap.get("doctorId").toString()) ;
		String from = userMap.get("fromDate").toString();
		String userId = userMap.get("userId").toString();
		String to = userMap.get("toDate").toString();
		 ReportValidation reportValidation = doctorIncomeService.getDoctorIncomeReport(userId,clinicId, doctorId, from, to);
		 return new ResponseEntity<ReportValidation>(reportValidation,HttpStatus.OK);
	}

	

}
