package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Long>{
	
	@Query(value="SELECT COUNT(*) FROM helthplus301_user u WHERE u.user_name = :username",nativeQuery = true)
	Integer getCountByEmail(@Param("username") String username);
	
	@Query(value="SELECT * FROM helthplus301_user u WHERE u.user_name = :username",nativeQuery = true)
	UserDTO findByUserName(@Param("username") String username);
	
	@Query(value="SELECT * FROM helthplus301_user u WHERE u.clinic_id = :clinicId AND u.is_doctor=true",nativeQuery = true)
	List<UserDTO> findUsersByClinidId(@Param("clinicId") Long clinicId);
	
	@Query(value="SELECT * FROM helthplus301_user u WHERE u.clinic_id = :clinicId",nativeQuery = true)
	List<UserDTO> findAllUsersByClinidId(@Param("clinicId") Long clinicId);
	
	@Query(value="SELECT * FROM helthplus301_user u WHERE u.id = :id",nativeQuery = true)
	UserDTO findUserById(@Param("id") Long id);
	
	@Query(value="SELECT COUNT(*) FROM helthplus301_user u WHERE u.slmc_number = :slmc AND u.clinic_id = :clinicId",nativeQuery = true)
	Integer findUserByClnicSLMC(@Param("clinicId") Long clinicId,@Param("slmc") String slmc);
	
	UserDTO findById(long id);

}
