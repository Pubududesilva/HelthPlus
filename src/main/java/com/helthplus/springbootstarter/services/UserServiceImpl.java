package com.helthplus.springbootstarter.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.tomcat.util.buf.UDecoder;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.common.JwtToken;
import com.helthplus.springbootstarter.common.Utils;
import com.helthplus.springbootstarter.domain.ClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.RollDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.domain.ValidationFactorsDTO;
import com.helthplus.springbootstarter.repositories.ClinicRepository;
import com.helthplus.springbootstarter.repositories.DoctorClinicRepository;
import com.helthplus.springbootstarter.repositories.RollRepository;
import com.helthplus.springbootstarter.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService  {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicRepository clinicRepository; 
	
	@Autowired
	RollRepository rollRepository; 
	
	@Autowired
	DoctorClinicRepository doctorClinicRepository;
	
	
	
	@Override
	public UserValidationDTO createUser(UserDTO userDTO) {
		Integer count = userRepository.getCountByEmail(userDTO.getUserName());
		Integer dto =  userRepository.findUserByClnicSLMC(userDTO.getClinicId(), userDTO.getSlmcNumber());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		Utils utils = new Utils();
		RollDTO rollDTO = new RollDTO();
		JwtToken jwtToken = new JwtToken();
		ErrorDTO errorDto = new ErrorDTO();
		if(count > 0){
			
			if(userDTO.getId() > 0){
				UserDTO currentUserDto = userRepository.findById(userDTO.getId());
				if(!currentUserDto.getPassword().equals(userDTO.getPassword())){
					String hashPassword = utils.encrypyPassword(userDTO.getPassword());
					userDTO.setPassword( hashPassword);
				}
				userRepository.save(userDTO);
				userValidationDTO.setStatus(1);
				userValidationDTO.setHttpCode(200);
				return userValidationDTO;
				
			}else{
				errorDto.setError(Constant.USERNAMEDUPLICATE);
				errorDto.setMessage(Constant.USERNAMEDUPLICATE);
				userValidationDTO.setError(errorDto);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				return userValidationDTO;
			}

		}
		if(dto > 0 && userDTO.getRole().equals("Doctor")){
			errorDto.setError(Constant.USERALREADYASSIGN);
			errorDto.setMessage(Constant.USERALREADYASSIGN);
			userValidationDTO.setError(errorDto);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}

		
		String token = jwtToken.generateJWTTokenToUser(userDTO);
		String hashPassword = utils.encrypyPassword(userDTO.getPassword());
//		String hashPassword = BCrypt.hashpw(dto.getUsrPasswrd(), BCrypt.gensalt(10));
		userDTO.setPassword( hashPassword);
		rollDTO = rollRepository.findByRoleName(userDTO.getRole());

		if(rollDTO != null){
			userDTO.setRoleId(rollDTO.getId());
			userDTO.setCreateDate(new Date());
			if(userDTO.getRole().equals("Doctor")){
				userDTO.setDoctor(true);
				DoctorClinicDTO doctorClinicDTO =doctorClinicRepository.findBySlmc(userDTO.getSlmcNumber());
				
				
				if(doctorClinicDTO == null){
					errorDto.setError(Constant.INVALIDSLMCNUMBER);
					errorDto.setMessage(Constant.INVALIDSLMCNUMBER);
					userValidationDTO.setError(errorDto);
					userValidationDTO.setHttpCode(500);
					userValidationDTO.setStatus(0);
					return userValidationDTO;
				}
				if(doctorClinicDTO != null && !doctorClinicDTO.isEmailVerify()){
					errorDto.setError(Constant.EMAILNOTVERIFY);
					errorDto.setMessage(Constant.EMAILNOTVERIFY);
					userValidationDTO.setError(errorDto);
					userValidationDTO.setHttpCode(500);
					userValidationDTO.setStatus(0);
					return userValidationDTO;
				}

			}
			
			else{
				userDTO.setDoctor(false);
			}
		}
		

		UserDTO userDTO2 =  userRepository.save(userDTO);

		if(userDTO2 != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setAccessToken(token);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO loginUser(UserDTO userDTO) {
		UserDTO dto = userRepository.findByUserName(userDTO.getUserName());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		Utils utils = new Utils();
		JwtToken jwtToken = new JwtToken();
		if(dto == null){
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError(Constant.INVALIDUSERNAME);
			userValidationDTO.setStatus(0);
			userValidationDTO.setHttpCode(500);
			return userValidationDTO;
		}
		if(!BCrypt.checkpw(userDTO.getPassword(),dto.getPassword())){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.PASSWORD);
			factorsDTO.setValidationError(Constant.LOGINFAIL);
			userValidationDTO.setStatus(0);
			userValidationDTO.setHttpCode(500);
			return userValidationDTO;
		}
		ClinicDTO clinicDTO = (ClinicDTO) clinicRepository.findById(dto.getClinicId());
		RollDTO rollDTO = rollRepository.findById(dto.getRoleId());
		List<UserDTO> userDTOList = userRepository.findUsersByClinidId(dto.getClinicId());
		userValidationDTO.setRollDTO(rollDTO);
		userValidationDTO.setClinicDoctors(userDTOList);
		userValidationDTO.setClinicDTO(clinicDTO);
		userValidationDTO.setHttpCode(200);
		userValidationDTO.setStatus(1);
		userValidationDTO.setUserDTO(dto);
		userValidationDTO.setAccessToken(jwtToken.generateJWTTokenToUser(userDTO));
		
		return userValidationDTO;
	}
	
	@Override
	public UserValidationDTO getAllClinicUser(UserDTO userDTO){
		UserDTO dto = userRepository.findById(userDTO.getId());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		Utils utils = new Utils();
		if(dto == null){
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError(Constant.INVALIDUSERNAME);
			userValidationDTO.setStatus(0);
			userValidationDTO.setHttpCode(500);
			return userValidationDTO;
		}else{
			ClinicDTO clinicDTO = (ClinicDTO) clinicRepository.findById(dto.getClinicId());
			RollDTO rollDTO = rollRepository.findById(dto.getRoleId());
			List<UserDTO> userDTOList = userRepository.findAllUsersByClinidId(dto.getClinicId());
//			dto.setPassword("");
			userValidationDTO.setRollDTO(rollDTO);
			userValidationDTO.setClinicDTO(clinicDTO);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTO(dto);
			userValidationDTO.setClinicDoctors(userDTOList);
			return userValidationDTO;
		}
	}
	
	
	@Override
	public UserValidationDTO getSystemUserById(UserDTO dto) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		UserDTO userDto = userRepository.findById(dto.getId());
		userValidationDTO.setUserDTO(userDto);
		userValidationDTO.setStatus(1);
		userValidationDTO.setHttpCode(200);
		return userValidationDTO;
	}
	
	
	@Override
	public UserValidationDTO deleteClinicUserById(UserDTO userDTO) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		userRepository.delete(userDTO);
		userValidationDTO.setStatus(1);
		userValidationDTO.setHttpCode(200);
		return userValidationDTO;
	}
	
	
	@Override
	public UserValidationDTO getClinicUser(UserDTO userDTO) {
		UserDTO dto = userRepository.findById(userDTO.getId());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		Utils utils = new Utils();
		if(dto == null){
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setError(Constant.INVALIDUSERNAME);
			userValidationDTO.setStatus(0);
			userValidationDTO.setHttpCode(500);
			return userValidationDTO;
		}else{
			ClinicDTO clinicDTO = (ClinicDTO) clinicRepository.findById(dto.getClinicId());
			RollDTO rollDTO = rollRepository.findById(dto.getRoleId());
			List<UserDTO> userDTOList = userRepository.findUsersByClinidId(dto.getClinicId());
//			dto.setPassword("");
			userValidationDTO.setRollDTO(rollDTO);
			userValidationDTO.setClinicDTO(clinicDTO);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTO(dto);
			userValidationDTO.setClinicDoctors(userDTOList);
			return userValidationDTO;
		}
	}
	
	@Override
	public UserValidationDTO getSystemDoctorsByClinicId(UserDTO userDTO) {
		UserDTO dto = userRepository.findById(userDTO.getId());
		return null;
	}

	@Override
	public UserValidationDTO createSystemUser(UserDTO userDTO) {
		UserDTO dto =  userRepository.save(userDTO);
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		if(dto != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO uploadUserImage(MultipartFile file, Long userId) {
		Utils utils = new Utils();
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		String url =  utils.getCloudinaryUrlByMultipartImage(file);
		UserDTO dto = userRepository.findUserById(userId);
		dto.setImgUrl(url);
		UserDTO userDTO =  userRepository.save(dto);
		if(userDTO != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTO(userDTO);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}



}
