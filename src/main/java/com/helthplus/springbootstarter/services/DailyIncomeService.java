package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.ReportValidation;

public interface DailyIncomeService {
	
	ReportValidation getDailyIncomeByDateRange(long clinicId, long doctorId,String uId, String fromDate, String toDate); 
	
//	ReportValidation getDailyIncomeByDoctorId(long clinicId, long doctorId,String uId); 

}
