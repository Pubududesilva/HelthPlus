package com.helthplus.springbootstarter.services;

import com.helthplus.springbootstarter.domain.RollDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;

public interface RollService {
	
	UserValidationDTO createRoll(RollDTO rollDTO);
	
	
	

}
