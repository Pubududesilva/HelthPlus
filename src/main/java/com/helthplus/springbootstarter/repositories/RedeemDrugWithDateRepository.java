package com.helthplus.springbootstarter.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.DrugBalanceDTO;
import com.helthplus.springbootstarter.domain.RedeemDrugWithDate;

public interface RedeemDrugWithDateRepository extends CrudRepository<RedeemDrugWithDate, Long> {
	
	@Query(value="SELECT *, sum(d.redeem_quantity) total  FROM vw_drug_redeem_with_name d WHERE  d.clinic_id=:clinic_id and d.drug_setting_id=:medicine AND d.create_date between :fromTime and :toTime group by d.drug,d.clinic_id",nativeQuery = true)
	 List<RedeemDrugWithDate> findRedeemDrugMedicine(@Param("clinic_id") Long clinic_id,@Param("medicine") Long medicine,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;
	
	@Query(value="SELECT *, sum(d.redeem_quantity) total  FROM vw_drug_redeem_with_name d WHERE  d.clinic_id=:clinic_id and d.create_date between :fromTime and :toTime group by d.drug,d.clinic_id",nativeQuery = true)
	 List<RedeemDrugWithDate> findRedeemDrugWithClinic(@Param("clinic_id") Long clinic_id,@Param("fromTime") String fromTime,@Param("toTime") String toTime) ;
	
	@Query(value="SELECT *, sum(d.redeem_quantity) total  FROM vw_drug_redeem_with_name d WHERE  d.clinic_id=:clinic_id group by d.drug,d.clinic_id",nativeQuery = true)
	 List<RedeemDrugWithDate> findRedeemAllDrug(@Param("clinic_id") Long clinic_id) ;
	
	@Query(value="SELECT *, sum(d.redeem_quantity) total  FROM vw_drug_redeem_with_name d WHERE  d.clinic_id=:clinic_id and d.drug_setting_id=:medicine group by d.drug,d.clinic_id",nativeQuery = true)
	 List<RedeemDrugWithDate> findRedeemDrugHistory(@Param("clinic_id") Long clinic_id,@Param("medicine") Long medicine) ;
	
	
//	@Query(value="SELECT * FROM vm_drug_balance u WHERE u.brand_id = :id AND u.clinic_id=:clinicId",nativeQuery = true)
//	List<DrugBalanceDTO> findByBrandId( @Param("id") long id, @Param("clinicId") long clinicId);
//
//	@Query(value="SELECT * FROM vm_drug_balance u WHERE u.clinic_id=:clinicId",nativeQuery = true)
//	List<DrugBalanceDTO> findByClinicId( @Param("clinicId") long clinicId);


	
}
