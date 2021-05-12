package com.helthplus.springbootstarter.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.InvestigationDTO;

public interface InvestigationRepo extends CrudRepository<InvestigationDTO, Long> {

	@Query(value="update helthplus301_pls_investigation u set u.investgation_result =:result WHERE u.id =:id",nativeQuery = true)
	 InvestigationDTO updateInvestigationById(@Param("id") Long id,@Param("result") String result) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_investigation u WHERE u.id =:id",nativeQuery = true)
	InvestigationDTO findInvestgationById(@Param("id") Long id);
}
