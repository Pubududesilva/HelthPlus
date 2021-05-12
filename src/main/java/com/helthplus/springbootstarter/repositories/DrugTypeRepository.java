package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DrugTypeDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;

public interface DrugTypeRepository extends CrudRepository<DrugTypeDTO, Long> {
	
	@Query(value="SELECT * FROM helthplus301_pls_drug_type u  WHERE u.clinic_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	List<DrugTypeDTO> getAlDrugTypeByClinicId(@Param("id") long id) ;

	@Query(value="SELECT COUNT(*) FROM helthplus301_pls_drug_type u WHERE u.type = :drugtype AND u.clinic_id=:id",nativeQuery = true)
	Integer getDrugType(@Param("drugtype") String drugtype,@Param("id") long id);

}
