package com.helthplus.springbootstarter.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.PatientDTO;

public interface PatientRepository extends CrudRepository<PatientDTO, Long>  {
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.first_name=:firstName and u.last_name=:lastName ",nativeQuery = true)
	 List<PatientDTO> findPatientByUserName(@Param("firstName") String firstName,@Param("lastName") String lastName) ;
	

	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.id =:id",nativeQuery = true)
	List<PatientDTO> findPatientByUserId(@Param("id") long id) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.first_name LIKE %?1% "
			+" AND u.last_name LIKE %?2%"
			+" AND u.date_of_birth LIKE '%?3%' "
			+ " AND u.doctor_slmc_number LIKE '%?4%'  "
			+ " ",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByUserFirstName( String firstName,String lastName,Date dob, String doctorSlmc) ;
	
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1 AND u.first_name LIKE %?2% AND u.last_name LIKE %?3% AND u.date_of_birth = ?4",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByNameAndDOB( String doctorSlmc,String firstName,String lastName, Date dob) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1 AND u.first_name LIKE %?2% AND u.last_name LIKE %?3% ",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByFirstNameANDLastName( String doctorSlmc,String firstName,String lastName) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1 AND u.first_name LIKE %?2% AND u.date_of_birth = ?4",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsFirstNameAndDOB( String doctorSlmc,String firstName, Date dob) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1 AND u.first_name LIKE %?2% ",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByFirstName( String doctorSlmc,String firstName) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1 AND u.last_name LIKE %?2% ",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByLastName( String doctorSlmc,String lastName) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u WHERE u.doctor_slmc_number = ?1  AND u.date_of_birth = ?2",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByUserDOB( String doctorSlmc,  Date dob) ;
	
	List<PatientDTO> findByDoctorSlmc(String doctorSlmc);
	
	@Query(value="SELECT * FROM helthplus301_pls_patient u join helthplus301_pls_doctor_clinic c on p.doctor_slmc_number = c.slmc WHERE  u.first_name LIKE %?1% ",nativeQuery = true)
	 List<PatientDTO> findPatientDetailsByClinicANDFName( String firstName) ;
	
//	List<PatientDTO> findPatientDetailsByUserFirstName(String firstName,String lastName,String dob);
	
}
