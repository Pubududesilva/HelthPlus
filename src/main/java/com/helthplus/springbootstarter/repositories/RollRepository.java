package com.helthplus.springbootstarter.repositories;

import org.springframework.data.repository.CrudRepository;


import com.helthplus.springbootstarter.domain.RollDTO;

public interface RollRepository extends CrudRepository<RollDTO, Long> {
	
	RollDTO findById(long id);
	
	RollDTO findByRoleName(String role);
	

}
