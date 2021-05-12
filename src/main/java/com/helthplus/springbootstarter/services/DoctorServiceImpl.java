package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.common.JwtToken;
import com.helthplus.springbootstarter.common.Utils;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.EmailRequestDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.domain.ValidationFactorsDTO;
import com.helthplus.springbootstarter.repositories.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Value("${spring.defaultImageUrl}")
	private String defaultImgUrl;
	
	@Override
	public UserValidationDTO loginUser(String email,String password) {
			UserValidationDTO userValidationDTO = new UserValidationDTO();
			JwtToken jwtToken = new JwtToken();
			ErrorDTO errorDTO = new ErrorDTO();
			List<DoctorDTO> userList = new ArrayList<DoctorDTO>();
			List<DoctorDTO> list = new ArrayList<DoctorDTO>();
			List<ValidationFactorsDTO> userDtoList = new ArrayList<ValidationFactorsDTO>();
			List<ValidationFactorsDTO> validateUserDtoList = validateUserLoginDto(email,password);
			if(validateUserDtoList.size()>0){
				userValidationDTO.setValidationFactor(validateUserDtoList);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				errorDTO.setError(validateUserDtoList.get(0).getFieldName());
				errorDTO.setMessage(validateUserDtoList.get(0).getValidationError());
				userValidationDTO.setError(errorDTO);
				return userValidationDTO;
			}
			if(email != null) email = email.toLowerCase();
			DoctorDTO userDto =  doctorRepo.findByEmailAndPassword(email);
			if(!BCrypt.checkpw(password,userDto.getPassword())){
				ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
				factorsDTO.setFieldName(Constant.PASSWORD);
				factorsDTO.setValidationError(Constant.LOGINFAIL);
				userDtoList.add(factorsDTO);
				userValidationDTO.setValidationFactor(validateUserDtoList);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				userValidationDTO.setValidationFactor(userDtoList);
				return userValidationDTO;
			}
			if(!userDto.getIsEmailVerify()){
				errorDTO.setError(Constant.EMAILNOTVERIFY);
				errorDTO.setMessage(Constant.EMAILNOTVERIFY);
				userValidationDTO.setError(errorDTO);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				userValidationDTO.setValidationFactor(userDtoList);
				return userValidationDTO;
				
			}
			
			userList.add(userDto);
			userValidationDTO.setUserDTos(userList);;
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setAccessToken(jwtToken.generateJWTToken(userDto));
			
			return userValidationDTO;
			
		
	}
	
	public List<ValidationFactorsDTO> validateUserLoginDto(String email,String password){
		List<ValidationFactorsDTO> userDtoList = new ArrayList<ValidationFactorsDTO>();
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email.equals(null) || email.isEmpty()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.USERNAME);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			 userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(password.equals(null) || password.isEmpty()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.PASSWORD);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			 userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(!pattern.matcher(email).matches()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.EMAIL);
			factorsDTO.setValidationError(Constant.INVALIDFORMAT);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(email != null) email = email.toLowerCase();
		DoctorDTO userDto =  doctorRepo.findByEmailAndPassword(email);
		if(userDto != null){
			if(!userDto.getIsEmailVerify()){
				ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
				factorsDTO.setFieldName(Constant.EMAIL);
				factorsDTO.setValidationError(Constant.EMAILNOTVERIFY);
				userDtoList.add(factorsDTO);
				 return userDtoList;
			}
				if(!BCrypt.checkpw(password,userDto.getPassword())){
					ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
					factorsDTO.setFieldName(Constant.PASSWORD);
					factorsDTO.setValidationError(Constant.LOGINFAIL);
					userDtoList.add(factorsDTO);
					return userDtoList;
				}

			
			
		}else{
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.EMAIL);
			factorsDTO.setValidationError(Constant.EMAILNOTFOUND);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		
		return userDtoList;
	}

	@Override
	public UserValidationDTO getUserById(DoctorDTO dto) {
		DoctorDTO userDTO = (DoctorDTO)  doctorRepo.findUserByUserId(dto.getId());
//		List<PatientDTO> pDto = (List<PatientDTO>) dto.getPatientDTOs();
//		System.out.println(dto.getPatientDTOs().size());
		List<DoctorDTO> list = new ArrayList<DoctorDTO>();
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		if(userDTO != null){
			list.add(userDTO);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTos(list);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}

	@Override
	public UserValidationDTO createUser(DoctorDTO dto) {
			Utils utils = new Utils();
			ErrorDTO errorDto = new ErrorDTO();
			JwtToken jwtToken = new JwtToken();
			UserValidationDTO userValidationDTO = new UserValidationDTO();
			dto.setImgUrl(defaultImgUrl);
			List<ValidationFactorsDTO> validateUserDtoList = validateUserDto(dto);
			if(validateUserDtoList.size()>0){
				userValidationDTO.setValidationFactor(validateUserDtoList);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				return userValidationDTO;
			}
			if(dto.getId() > 0){
				List<DoctorDTO> userList = new ArrayList<DoctorDTO>();
				DoctorDTO doctorDTO =  doctorRepo.save(dto);
				userList.add(doctorDTO);
				userValidationDTO.setUserDTos(userList);
				userValidationDTO.setHttpCode(200);
				userValidationDTO.setStatus(1);
				return userValidationDTO;
			}
			Integer count = doctorRepo.getCountByEmail(dto.getEmail());
			if(count > 0){
				errorDto.setError(Constant.EMAILDUPLICATE);
				errorDto.setMessage(Constant.EMAILDUPLICATE);
				userValidationDTO.setError(errorDto);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(500);
				return userValidationDTO;
			}
			
			String token = jwtToken.generateJWTToken(dto);
			String hashPassword = utils.encrypyPassword(dto.getPassword());
//			String hashPassword = BCrypt.hashpw(dto.getUsrPasswrd(), BCrypt.gensalt(10));
			dto.setPassword( hashPassword);

			EmailRequestDTO emailRequestDTO =  emailService.sendEmail(dto.getEmail(), token, null);
			dto.setUserEmailDTO(emailRequestDTO.getUserEmailDTO());
			
			if(emailRequestDTO.getStatusCode() != 200){
				
				userValidationDTO.setValidationFactor(validateUserDtoList);
				userValidationDTO.setStatus(0);
				userValidationDTO.setHttpCode(emailRequestDTO.getStatusCode());
				errorDto.setError(emailRequestDTO.getStatus());
				errorDto.setMessage(emailRequestDTO.getStatus());
				userValidationDTO.setError(errorDto);
				return userValidationDTO;
			}
			
			List<DoctorDTO> userList = new ArrayList<DoctorDTO>();
			DoctorDTO doctorDTO =  doctorRepo.save(dto);
			userList.add(doctorDTO);
			userValidationDTO.setUserDTos(userList);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setAccessToken(token);
			return userValidationDTO;
		}
	
	public List<ValidationFactorsDTO> validateUserDto(DoctorDTO userDto){
		List<ValidationFactorsDTO> userDtoList = new ArrayList<ValidationFactorsDTO>();
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		
		if(userDto.getFirstName().equals(null) || userDto.getFirstName().isEmpty()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.FIRSTNAME);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			 userDtoList.add(factorsDTO);
			 return userDtoList;

		}
		
		if(userDto.getFirstName().matches(".*\\d.*")){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.FIRSTNAME);
			factorsDTO.setValidationError(Constant.INVALIDFORMAT);
			 userDtoList.add(factorsDTO);
			 return userDtoList;

		}
		
		if(userDto.getLastName().equals(null) || userDto.getLastName().isEmpty()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.LASTNAME);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			 userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(userDto.getLastName().matches(".*\\d.*")){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.LASTNAME);
			factorsDTO.setValidationError(Constant.INVALIDFORMAT);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(userDto.getEmail().equals(null)){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.EMAIL);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(!pattern.matcher(userDto.getEmail()).matches()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.EMAIL);
			factorsDTO.setValidationError(Constant.INVALIDFORMAT);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		if(userDto.getPassword().equals(null) || userDto.getPassword().isEmpty()){
			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
			factorsDTO.setFieldName(Constant.PASSWORD);
			factorsDTO.setValidationError(Constant.EMPTYFIELD);
			userDtoList.add(factorsDTO);
			 return userDtoList;
		}
		
		
		
		return userDtoList;
	}

	@Override
	public UserValidationDTO getAllDoctor() {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<DoctorDTO> doctorDTOList = (List<DoctorDTO>) doctorRepo.findAll();
		userValidationDTO.setUserDTos(doctorDTOList);
		userValidationDTO.setHttpCode(200);
		userValidationDTO.setStatus(1);
		return userValidationDTO;
	}

	@Override
	public UserValidationDTO getDoctorBySLMCNumber(DoctorDTO dto) {
		DoctorDTO userDTO = (DoctorDTO)  doctorRepo.findDoctorBySLMCNumber(dto.getSlmcNumber());
//		List<PatientDTO> pDto = (List<PatientDTO>) dto.getPatientDTOs();
//		System.out.println(dto.getPatientDTOs().size());
		List<DoctorDTO> list = new ArrayList<DoctorDTO>();
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		if(userDTO != null){
			list.add(userDTO);
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTos(list);
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
		DoctorDTO dto = doctorRepo.findUserByUserId(userId);
		List<DoctorDTO> list = new ArrayList<>();
		dto.setImgUrl(url);
		DoctorDTO userDTO =  doctorRepo.save(dto);
		list.add(userDTO);
		if(userDTO != null){
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setUserDTos(list);
			return userValidationDTO;
		}else{
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			return userValidationDTO;
		}
	}


}
