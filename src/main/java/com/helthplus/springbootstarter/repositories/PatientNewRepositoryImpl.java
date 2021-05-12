package com.helthplus.springbootstarter.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.helthplus.springbootstarter.domain.PatientDTO;

public class PatientNewRepositoryImpl implements PatientNewRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String SQL_FIND_PATIENT_BY_NAME = "SELECT * FROM helthplus301_pls_patient s WHERE where (s.first_name like '%?%' OR s.last_name like '%?%' ) AND s.doctor_slmc_number = ? ";

	@Override
	public List<PatientDTO> findPatientDetailsByUserFirstName(String firstName, String lastName, Date dob,
			String doctorSlmc) {
//		jdbcTemplate.queryForObject(SQL_FIND_PATIENT_BY_NAME, new Object[]{firstName,lastName,doctorSlmc},patientRowMapper)

		return null;
	}

}
