package com.helthplus.springbootstarter.services;

import java.util.Date;
import java.util.List;

import com.helthplus.springbootstarter.domain.ReportValidation;


public interface RedeemDrugWithDateService {
	
	ReportValidation getRedeemDrugByDate(long clinicId, String medicineId,String userId,String fromDate,String toDate);

}
