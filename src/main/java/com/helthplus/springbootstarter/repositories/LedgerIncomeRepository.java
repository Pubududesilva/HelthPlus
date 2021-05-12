package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.LedgerIncomeDTO;

public interface LedgerIncomeRepository  extends CrudRepository<LedgerIncomeDTO, Long>{
	
	@Query(value="SELECT *,sum(d.amount) total FROM vw_ledger_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId AND d.create_date between :fromTime and :toTime group by d.doctor_id,d.clinic_id",nativeQuery = true)
	 List<LedgerIncomeDTO> findLedgerIncomeWithDateRange(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;

	@Query(value="SELECT *,sum(d.amount) total FROM vw_ledger_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId group by d.doctor_id,d.clinic_id",nativeQuery = true)
	 List<LedgerIncomeDTO> findLedgerIncome(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId) ;

	
	@Query(value="SELECT *,d.amount total FROM vw_ledger_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId AND d.create_date between :fromTime and :toTime",nativeQuery = true)
	 List<LedgerIncomeDTO> findLedgerIncomeDetailsWithDateRange(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;

	@Query(value="SELECT *,d.amount total FROM vw_ledger_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId",nativeQuery = true)
	 List<LedgerIncomeDTO> findLedgerIncomeDetails(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId) ;

//	@Query(value="SELECT * FROM vw_ledger_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId AND d.create_date between :fromTime and :toTime group by d.doctor_id,d.clinic_id",nativeQuery = true)
//	 List<LedgerIncomeDTO> findLedgerIncome(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;

}
