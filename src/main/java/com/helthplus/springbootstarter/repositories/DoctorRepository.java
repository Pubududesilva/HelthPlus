package com.helthplus.springbootstarter.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;

public interface DoctorRepository extends CrudRepository<DoctorDTO, Long> {
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.user_name =:userName and u.passwd=:password ",nativeQuery = true)
	 DoctorDTO findUserByUserNamePassword(@Param("userName") String userName,@Param("password") String password) ;
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.user_email_id =:emailId ",nativeQuery = true)
	 DoctorDTO findDoctorByEmailId(@Param("emailId") Long emailId) ;
	
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.email = :email",nativeQuery = true)
	DoctorDTO findByEmailAndPassword(@Param("email") String email);
	

	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.id =:id",nativeQuery = true)
	 DoctorDTO findUserByUserId(@Param("id") Long id) ;
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.slmc_number =:slmc",nativeQuery = true)
	 DoctorDTO findDoctorBySLMCNumber(@Param("slmc") String slmc) ;
	
	@Query(value="SELECT COUNT(*) FROM helthplus301_doctor u WHERE u.EMAIL = :email",nativeQuery = true)
	Integer getCountByEmail(@Param("email") String email);
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.EMAIL = :email",nativeQuery = true)
	DoctorDTO findByEmail(@Param("email") String email);
	
	@Transactional
    @Modifying
	@Query(value="update helthplus301_doctor u set u.username =:userName, u.profile_img_url =:imagePath WHERE u.user_id =:userId",nativeQuery = true)
	void updateUser(@Param("userId") Integer userId,@Param("userName") String userName,@Param("imagePath") String imagePath) ;
	
    @Transactional
    @Modifying
	@Query(value="update helthplus301_doctor u set u.is_email_verify =:isEmailVerified WHERE u.user_email_id =:userId",nativeQuery = true)
	int updateUserEmailVerificationByUserid(@Param("userId") Long userId,@Param("isEmailVerified") Boolean isEmailVerified) ;
	
    @Transactional
    @Modifying
	@Query(value="update helthplus301_doctor u set u.user_email_id =:resetPassword WHERE u.email =:email",nativeQuery = true)
	void updateResetPasswordField(@Param("email") String email,@Param("resetPassword") String resetPassword) ;
	
    
//	UserDTO findByUserId(Integer userId);
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.username = :userName",nativeQuery = true)
	DoctorDTO findUserByUserName(@Param("userName") String userName) ;

	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.firstname = :firstName",nativeQuery = true)
	DoctorDTO findUserByFullName(@Param("firstName") String firstName) ;
	
	@Query(value="SELECT * FROM helthplus301_doctor u WHERE u.EMAIL = :email",nativeQuery = true)
	DoctorDTO findDoctorByEmail(@Param("email") String email);
	
	
}
