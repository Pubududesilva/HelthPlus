package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DiagnosisDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;

public interface DiagnosisRepository  extends CrudRepository<DiagnosisDTO, Long> {
	
	@Query(value="SELECT * FROM helthplus301_pls_diagnosis u WHERE u.patient_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	List<DiagnosisDTO> findDiagnosisByPatientId(@Param("id") long id) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_diagnosis u WHERE u.investigation_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	DiagnosisDTO findDiagnosisByInvetigationId(@Param("id") long id) ;
	
	DiagnosisDTO findById(@Param("id") long id);

}
