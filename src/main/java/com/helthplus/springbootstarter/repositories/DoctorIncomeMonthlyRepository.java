package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DoctorIncomeByMonthly;
import com.helthplus.springbootstarter.domain.LedgerIncomeDTO;

public interface DoctorIncomeMonthlyRepository extends CrudRepository<DoctorIncomeByMonthly, Long> {
	
	@Query(value="SELECT * FROM vm_doctor_income_by_monthly u WHERE u.clinic_id = :clinicId and u.doctor_id=:docId AND u.create_date between :fromTime and :toTime",nativeQuery = true)
	List<DoctorIncomeByMonthly> findByDoctorIncomeById(@Param("clinicId") Long clinicId,@Param("docId") Long docId,@Param("fromTime") String fromTime,@Param("toTime") String toTime);
	
	@Query(value="SELECT * FROM vm_doctor_income_by_monthly u WHERE u.clinic_id = :clinicId and u.doctor_id=:docId",nativeQuery = true)
	List<DoctorIncomeByMonthly> findByDoctorAllIncomeById(@Param("clinicId") Long clinicId,@Param("docId") Long docId);
	
}
