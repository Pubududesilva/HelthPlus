package com.helthplus.springbootstarter.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorEmailDTO;

public interface DoctorClinicRepository extends CrudRepository<DoctorClinicDTO, Long> {
	
	@Query(value="SELECT COUNT(*) FROM helthplus301_pls_doctor_clinic u WHERE u.clinic_id = :clinicId and u.doctor_id=:docId ",nativeQuery = true)
	Integer findByDoctor(@Param("clinicId") Long clinicId,@Param("docId") Long docId);
	
	@Query(value="SELECT * FROM helthplus301_pls_doctor_clinic u WHERE u.clinic_id = :clinicId and u.doctor_id=:docId ",nativeQuery = true)
	DoctorClinicDTO findByDoctorByClinicId(@Param("clinicId") Long clinicId,@Param("docId") Long docId);

	@Query(value="SELECT * FROM helthplus301_pls_doctor_clinic u WHERE email_key=:emailKey",nativeQuery = true)
	DoctorClinicDTO findEmailVerificationDtoByEmailKey(@Param("emailKey") String emailKey) ;

	
	@Query(value="SELECT * FROM helthplus301_pls_doctor_clinic u WHERE slmc=:slmc",nativeQuery = true)
	DoctorClinicDTO findBySlmc(@Param("slmc") String slmc) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_doctor_clinic u WHERE clinic_id=:clinicId",nativeQuery = true)
	List<DoctorClinicDTO> findDoctorByClinicId(@Param("clinicId") String clinicId) ;
	
	@Transactional
    @Modifying
	@Query(value="update helthplus301_pls_doctor_clinic u set u.verify_date =:verifyDate , u.is_email_verify=:isEmailVerify WHERE u.id =:id",nativeQuery = true)
	int updateUserEmailByEmaiID(@Param("id") Long id,@Param("isEmailVerify") Boolean isEmailVerify,@Param("verifyDate") Date verifyDate) ;
	

}
