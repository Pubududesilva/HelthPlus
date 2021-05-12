package com.helthplus.springbootstarter.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.ReportValidation;


public interface LedgerIncomeService {
	

	ReportValidation getLedgerIncomeByDateRange(long clinicId, long doctorId,String uId, String fromDate, String toDate); 
	
	ReportValidation getLedgerIncomeInDetail(long clinicId, long doctorId,String uId, String fromDate, String toDate); 


	

}
