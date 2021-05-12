package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.MedicineGenericNameDTO;

public interface MedicineGenericRepository extends CrudRepository<MedicineGenericNameDTO, Long>{

	@Query(value="SELECT * FROM helthplus301_pls_medicine_generic_name u WHERE u.clinic_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	List<MedicineGenericNameDTO> getAllMedicineGenericByClinicId(@Param("id") long id);
}
