package com.helthplus.springbootstarter.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helthplus.springbootstarter.domain.ResetPassword;

public interface ResetPasswordRepository  extends CrudRepository<ResetPassword, Long>{
	
	@Query(value="SELECT * FROM elthplus301_pls_reset_password_token u WHERE u.EMAIL = :email",nativeQuery = true)
	ResetPassword findByEmail(@Param("email") String email);

}
