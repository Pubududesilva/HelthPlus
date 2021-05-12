package com.helthplus.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.helthplus.springbootstarter.domain.AllergyDTO;

public interface AllergyRepository extends CrudRepository<AllergyDTO, Long> {
	
	List<AllergyDTO> findByPatientId(Long Id);

}
