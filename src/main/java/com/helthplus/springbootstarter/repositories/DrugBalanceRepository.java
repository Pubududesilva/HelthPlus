package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DrugBalanceDTO;

public interface DrugBalanceRepository extends CrudRepository<DrugBalanceDTO, Long> {
	
	@Query(value="SELECT * FROM vm_drug_balance u WHERE u.brand_id = :id AND u.clinic_id=:clinicId",nativeQuery = true)
	List<DrugBalanceDTO> findByBrandId( @Param("id") long id, @Param("clinicId") long clinicId);

	@Query(value="SELECT * FROM vm_drug_balance u WHERE u.clinic_id=:clinicId",nativeQuery = true)
	List<DrugBalanceDTO> findByClinicId( @Param("clinicId") long clinicId);
	
	@Query(value="SELECT * FROM vm_drug_balance u WHERE u.brand_id = :id",nativeQuery = true)
	DrugBalanceDTO findByDrugId( @Param("id") long id);



}
