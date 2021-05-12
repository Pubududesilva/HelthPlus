package com.helthplus.springbootstarter.repositories;

import org.springframework.data.repository.CrudRepository;

import com.helthplus.springbootstarter.domain.ClinicDTO;

public interface ClinicRepository  extends CrudRepository<ClinicDTO, Long>{
	
	ClinicDTO findById(long id);

}
