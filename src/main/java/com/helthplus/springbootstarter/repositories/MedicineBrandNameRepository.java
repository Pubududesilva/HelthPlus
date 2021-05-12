package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;

public interface MedicineBrandNameRepository extends CrudRepository<MedicineBrandNameDTO, Long> {
	
	@Query(value="SELECT * FROM helthplus301_pls_medicine_brand_name u  WHERE u.clinic_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	List<MedicineBrandNameDTO> getAlSupplierByClinicId(@Param("id") long id) ;

//	@Query(value="SELECT COUNT(*) FROM helthplus301_pls_medicine_brand_name u WHERE u.supplier_name = :supplierName AND u.clinic_id=:id",nativeQuery = true)
//	Integer getSupplierDTO(@Param("supplierName") String supplierName,@Param("id") long id);

}
