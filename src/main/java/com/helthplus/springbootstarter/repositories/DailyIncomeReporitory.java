package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DailyIncomeDTO;
import com.helthplus.springbootstarter.domain.LedgerIncomeDTO;

public interface DailyIncomeReporitory extends CrudRepository<DailyIncomeDTO,Long>{
	
	@Query(value="SELECT * FROM vw_daily_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId AND d.create_date between :fromTime and :toTime",nativeQuery = true)
	 List<DailyIncomeDTO> findDailyIncomeWithDateRange(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;

	@Query(value="SELECT * FROM vw_daily_income d WHERE  d.clinic_id=:clinic_id and d.doctor_id=:doctorId",nativeQuery = true)
	 List<DailyIncomeDTO> findDailyIncomeByDoctorId(@Param("clinic_id") Long clinic_id,@Param("doctorId") Long doctorId) ;

}
