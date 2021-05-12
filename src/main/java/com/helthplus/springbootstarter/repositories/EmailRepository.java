package com.helthplus.springbootstarter.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.DoctorEmailDTO;

public interface EmailRepository extends CrudRepository<DoctorEmailDTO,Long>{
	
	@Transactional
    @Modifying
	@Query(value="update helthplus301_pls_useremail u set u.verify_date =:verifyDate , u.is_email_verify=:isEmailVerify WHERE u.email_id =:emailId",nativeQuery = true)
	int updateUserEmailByEmaiID(@Param("emailId") Long emailId,@Param("isEmailVerify") Boolean isEmailVerify,@Param("verifyDate") Date verifyDate) ;
	

	@Query(value="SELECT * FROM helthplus301_pls_useremail u WHERE u.user_id =:userId and u.email=:email",nativeQuery = true)
	DoctorEmailDTO findEmailVerificationKeyByUserId(@Param("userId") Integer userId,@Param("email") String email) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_useremail u WHERE email_key=:emailKey",nativeQuery = true)
	DoctorEmailDTO findEmailVerificationDtoByEmailKey(@Param("emailKey") String emailKey) ;
	
	@Query(value="SELECT * FROM helthplus301_pls_useremail u WHERE u.email=:email",nativeQuery = true)
	DoctorEmailDTO isValidEmailByEmailAddress(@Param("email") String email) ;
}
