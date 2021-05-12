package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DrugTypeImageDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;

public interface DrugTypeImageRepository extends CrudRepository<DrugTypeImageDTO, Long> {
	
	@Query(value="SELECT * FROM helthplus301_pls_drug_type_image",nativeQuery = true)
	List<DrugTypeImageDTO> getAlDrugTypeImageDTOClinicId() ;

}
