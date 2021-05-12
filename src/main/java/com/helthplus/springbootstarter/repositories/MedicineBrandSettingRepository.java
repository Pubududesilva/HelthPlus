package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;

public interface MedicineBrandSettingRepository extends CrudRepository<MedicineBrandSettingDTO, Long> {

	@Query(value="SELECT * FROM helthplus301_pls_medicle_brand_setting u  WHERE u.clinic_id =:id ORDER BY u.create_date DESC",nativeQuery = true)
	List<MedicineBrandSettingDTO> getAllMedicineBrandSettingByClinicId(@Param("id") long id) ;

	@Query(value="SELECT COUNT(*) FROM helthplus301_pls_medicle_brand_setting u WHERE u.brand_name = :brandName AND u.clinic_id=:id",nativeQuery = true)
	Integer getMedicineSettingByBrand(@Param("brandName") String brandName,@Param("id") long id);
	
	@Query(value="SELECT * FROM helthplus301_pls_medicle_brand_setting u  WHERE u.id =:id ",nativeQuery = true)
	MedicineBrandSettingDTO getMedicineBrandSettingById(@Param("id") long id) ;


}
