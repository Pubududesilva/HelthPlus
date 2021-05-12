package com.helthplus.springbootstarter.services;


import com.helthplus.springbootstarter.domain.ReportValidation;

public interface DoctorIncomeService {
	
	ReportValidation getDoctorIncomeReport(String uId,long clinicId, long doctorId, String fromDate,
			String toDate);

}
