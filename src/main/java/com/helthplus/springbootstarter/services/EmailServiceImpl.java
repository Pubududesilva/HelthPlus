package com.helthplus.springbootstarter.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.common.JwtToken;
import com.helthplus.springbootstarter.common.Utils;
import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.EmailRequestDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.ResetPassword;
import com.helthplus.springbootstarter.domain.UserDTO;
import com.helthplus.springbootstarter.domain.DoctorEmailDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.domain.ValidationFactorsDTO;
import com.helthplus.springbootstarter.repositories.DoctorClinicRepository;
import com.helthplus.springbootstarter.repositories.DoctorRepository;
import com.helthplus.springbootstarter.repositories.EmailRepository;
import com.helthplus.springbootstarter.repositories.ResetPasswordRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.GoogleAnalyticsSetting;
import com.sendgrid.helpers.mail.objects.SubscriptionTrackingSetting;
import com.sendgrid.helpers.mail.objects.TrackingSettings;


@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	
	@Value("${app.sendgrid.templateId}")
	private String templateId;
	
	@Value("${app.sendgrid.key}")
	private String SENDGRID_API_KEY;
	
	@Value("${sengrid.email}")
	private String sengridEmail;
	
	@Value("${sengrid.emailSubject}")
	private String sengridEmailSubject;
	
	@Value("${sengrid.emailconformurl}")
	private String sengridEmailConformUrl;
	
	@Value("${sengrid.emailconformurlfordoctor}")
	private String sengridEmailConformUrlForDoctor;
	
	
	@Autowired
	SendGrid sendGrid;
	
	@Autowired
	EmailRepository emailRepo;
	
	@Autowired
	DoctorClinicRepository doctorClinicRepository;
	
	@Autowired
	DoctorRepository registerUserReop;
	
	@Autowired
	ResetPasswordRepository resetPasswordRepository; 

	
	@Override
	public String sendEmail1(String email) {
		TrackingSettings trackingSettings = new TrackingSettings();
		Mail mail = new Mail();		
		SubscriptionTrackingSetting subscriptionTrackingSetting = new SubscriptionTrackingSetting();
		    subscriptionTrackingSetting.setEnable(true);
		    subscriptionTrackingSetting.setText("text to insert into the text/plain portion of the message");
		    subscriptionTrackingSetting.setHtml("<html><body>html to insert into the text/html portion of the message</body></html>");
		    subscriptionTrackingSetting.setSubstitutionTag("Optional tag to replace with the open image in the body of the message");
		    trackingSettings.setSubscriptionTrackingSetting(subscriptionTrackingSetting);
		    GoogleAnalyticsSetting googleAnalyticsSetting = new GoogleAnalyticsSetting();
		    googleAnalyticsSetting.setEnable(true);
		    googleAnalyticsSetting.setCampaignSource("some source");
		    googleAnalyticsSetting.setCampaignTerm("some term");
		    googleAnalyticsSetting.setCampaignContent("some content");
		    googleAnalyticsSetting.setCampaignName("some name");
		    googleAnalyticsSetting.setCampaignMedium("some medium");
		    trackingSettings.setGoogleAnalyticsSetting(googleAnalyticsSetting);
			mail = new Mail(new Email(sengridEmail), sengridEmailSubject, new Email(email),new Content("text/html", "<h1>Hello</h1>"));		
			mail.setTrackingSettings(trackingSettings);
			
		
		    
			mail.setReplyTo(new Email(sengridEmail));
			Request request = new Request();

			com.sendgrid.Response response = null;

			try {

				request.setMethod(Method.POST);

				request.setEndpoint("mail/send");

				request.setBody(mail.build());

				response=this.sendGrid.api(request);
				
				System.out.println("Response is : "+response.getStatusCode());
				System.out.println("Response is : "+response.getBody());

			} catch (Exception ex) {


			}
			return "Email Send Sucess";
		
	}
	
	@Override
	public EmailRequestDTO sendEmail(String email,String token,Long userId) {
		EmailRequestDTO emailDto = new EmailRequestDTO();
		String emailUrl =  ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+sengridEmailConformUrlForDoctor;
		
		DoctorClinicDTO doctorClinicDto =  doctorClinicRepository.findEmailVerificationDtoByEmailKey(email);
		if(doctorClinicDto == null || (doctorClinicDto != null && !doctorClinicDto.isEmailVerify()) ){
			
			// message contains HTML markups
	        String message = "<i>Conform Clinic Verification</i><br>";
	        message += "<h2>Please verify the Clinic verification link. </h2><br>";
	        message += "<a href="+emailUrl+token+">"+ "<h3> Email Conform</h3>" +" </a>";
			
			Content content = new Content("text/html", "and easy to do anywhere, even with Java");
			
			Mail mail = new Mail(new Email(sengridEmail), sengridEmailSubject, new Email(email),new Content("text/html", message));
			mail.setReplyTo(new Email(sengridEmail));
			Request request = new Request();

			com.sendgrid.Response response = null;

			try {

				request.setMethod(Method.POST);

				request.setEndpoint("mail/send");

				request.setBody(mail.build());

				response=this.sendGrid.api(request);
				if(response.getStatusCode() == 200 || response.getStatusCode() == 202 ){
					JwtToken jwtToken = new JwtToken();
					DoctorDTO userDTO = new DoctorDTO();
					userDTO.setEmail(email);
//					userDTO.setId(userId);
					
					DoctorEmailDTO emailDTO = new DoctorEmailDTO();
					emailDTO.setEmail(email);
					emailDTO.setEmailKey(token);
					emailDTO.setCreateDate(new Date());
					emailDto.setStatusCode(200);
					emailDto.setStatus(Constant.EMAILSUCESS);
					emailDto.setUserEmailDTO(emailDTO);
					return emailDto;
					
					}else{
						
						emailDto.setStatusCode(response.getStatusCode());
						emailDto.setStatus(response.getBody());
						return emailDto;
					}
				

			} catch (IOException ex) {

				System.out.println(ex.getMessage());

			}
			
		}
		
		
		
		return emailDto;
		
	}
	
	
	@Override
	public EmailRequestDTO sendEmailToUser(String email,String token,Long userId) {
		EmailRequestDTO emailDto = new EmailRequestDTO();
		
		String emailUrl =  ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+sengridEmailConformUrl;

		DoctorClinicDTO doctorClinicDto =  doctorClinicRepository.findEmailVerificationDtoByEmailKey(email);
		if(doctorClinicDto == null || (doctorClinicDto != null && !doctorClinicDto.isEmailVerify()) ){
			
			// message contains HTML markups
	        String message = "<i>Greetings!</i><br>";
	        message += "<h2>Let's verify your single sender so you can start sending email. </h2><br>";
	        message += "<a href="+emailUrl+token+">"+ "<h3> Email Conform</h3>" +" </a>";
			
			Content content = new Content("text/html", "and easy to do anywhere, even with Java");
			
			Mail mail = new Mail(new Email(sengridEmail), sengridEmailSubject, new Email(email),new Content("text/html", message));
			mail.setReplyTo(new Email(sengridEmail));
			Request request = new Request();

			com.sendgrid.Response response = null;

			try {

				request.setMethod(Method.POST);

				request.setEndpoint("mail/send");

				request.setBody(mail.build());

				response=this.sendGrid.api(request);
				if(response.getStatusCode() == 200 || response.getStatusCode() == 202 ){
					JwtToken jwtToken = new JwtToken();
					DoctorDTO userDTO = new DoctorDTO();
					userDTO.setEmail(email);
//					userDTO.setId(userId);
					
					DoctorEmailDTO emailDTO = new DoctorEmailDTO();
					emailDTO.setEmail(email);
					emailDTO.setEmailKey(token);
					emailDTO.setCreateDate(new Date());
					emailDto.setStatusCode(200);
					emailDto.setStatus(Constant.EMAILSUCESS);
					emailDto.setUserEmailDTO(emailDTO);
					return emailDto;
					
					}else{
						
						emailDto.setStatusCode(response.getStatusCode());
						emailDto.setStatus(response.getBody());
						return emailDto;
					}
				

			} catch (IOException ex) {

				System.out.println(ex.getMessage());

			}
			
		}
		
		
		
		return emailDto;
		
	}
	
	

	@Override
	public UserValidationDTO validateUserConformation(String token) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		DoctorDTO dto = new DoctorDTO();
		List<DoctorDTO> listDto = new ArrayList<>();
		ErrorDTO errorDTO = new ErrorDTO();
		DoctorClinicDTO doctorClinicDTO = doctorClinicRepository.findEmailVerificationDtoByEmailKey(token);
		if(doctorClinicDTO != null && !doctorClinicDTO.isEmailVerify()){
			doctorClinicRepository.updateUserEmailByEmaiID(doctorClinicDTO.getId(), true, new Date());
			registerUserReop.updateUserEmailVerificationByUserid(doctorClinicDTO.getDoctorId(), true);
			
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}if(doctorClinicDTO != null && doctorClinicDTO.isEmailVerify()){
			errorDTO.setMessage("Email Already Confirm ");
			errorDTO.setError("You have already clicked confirm link ");
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}else{
			
			errorDTO.setMessage("Not such email account ");
			errorDTO.setError("Email confirm link is invalid please try again ");
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}
	}

	
	@Override
	public UserValidationDTO validateDoctorConformation(String token) {
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		DoctorDTO dto = new DoctorDTO();
		List<DoctorDTO> listDto = new ArrayList<>();
		ErrorDTO errorDTO = new ErrorDTO();
		DoctorEmailDTO doctorEmailDTO = emailRepo.findEmailVerificationDtoByEmailKey(token);
		if(doctorEmailDTO != null && !doctorEmailDTO.isEmailVerify()){
//			doctorClinicRepository.updateUserEmailByEmaiID(doctorClinicDTO.getId(), true, new Date());
//			DoctorDTO doctorDTO = registerUserReop.findDoctorByEmailId(doctorEmailDTO.getUserId());
//			doctorDTO.setIsEmailVerify(true);
//			doctorEmailDTO.set
			emailRepo.updateUserEmailByEmaiID(doctorEmailDTO.getEmailId(), true, new Date());
			registerUserReop.updateUserEmailVerificationByUserid(doctorEmailDTO.getEmailId(), true);
			
			userValidationDTO.setHttpCode(200);
			userValidationDTO.setStatus(1);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}if(doctorEmailDTO != null && doctorEmailDTO.isEmailVerify()){
			errorDTO.setMessage("Email Already Confirm ");
			errorDTO.setError("You have already clicked confirm link ");
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}else{
			
			errorDTO.setMessage("Not such email account ");
			errorDTO.setError("Email confirm link is invalid please try again ");
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}
	}
	@Override
	public UserValidationDTO verifyEmailConformation(String token) {
		UserValidationDTO userValidationDTO = validateUserConformation(token);
		
		return userValidationDTO;
	}
	
	@Override
	public UserValidationDTO verifyDoctorEmailConformation(String token) {
		UserValidationDTO userValidationDTO = validateDoctorConformation(token);
		
		return userValidationDTO;
	}

	@Override
	public UserValidationDTO requestTokenForResetPasword(String email) {
//		UserValidationDTO userValidationDTO = new UserValidationDTO();
//		if(validateEmailAddress(email)){
//			Utils utils = new Utils();
//			String randomToken = utils.generateRandomNumber();
////			EmailRequestDTO emailRequestDTO = sendEmailWithToken(email, randomToken);
//			userValidationDTO.setHttpCode(200);
//			userValidationDTO.setStatus(1);
//			return userValidationDTO;
//			
//		}else{
//			userValidationDTO.setHttpCode(500);
//			userValidationDTO.setStatus(0);
//			return userValidationDTO;
		
//		}
		
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		DoctorDTO doctorDTO = registerUserReop.findDoctorByEmail(email);
		Utils utils = new Utils();
		if(doctorDTO != null){
			ResetPassword  resetPasswordDto = resetPasswordRepository.findByEmail(email);
			String token = String.valueOf(utils.generateToken());
			
			if(resetPasswordDto != null){
				resetPasswordDto.setCreateDate(new Date());
				resetPasswordDto.setToken( token  );
				resetPasswordRepository.save(resetPasswordDto);
			}else{
				ResetPassword resetPassword = new ResetPassword();
				resetPassword.setCreateDate(new Date());
				resetPassword.setEmail(doctorDTO.getEmail());
				resetPassword.setUserId(doctorDTO.getId());
				resetPassword.setToken( token  );
				resetPasswordRepository.save(resetPassword);
		
		}
		EmailRequestDTO emailRequestDTO = sendEmailWithToken(email, token);
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
	public UserValidationDTO resetPassword(String email,String newPassword,String token) {
		
		ResetPassword resetPassword = resetPasswordRepository.findByEmail(email);
		DoctorDTO doctorDTO = registerUserReop.findDoctorByEmail(email);
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		Utils utils = new Utils();
		ErrorDTO errorDTO = new ErrorDTO();
		if(resetPassword != null){
			Long createDate = resetPassword.getCreateDate().getTime();
			Long afterDate =  Constant.RESETPASSWORDVALIDTIME +createDate;
			Long newDate = new Date().getTime();
			
			if(!resetPassword.getToken().equals(token)){
				errorDTO.setError(Constant.INVALIDTOKEN);
				errorDTO.setMessage(Constant.INVALIDTOKEN);
				userValidationDTO.setHttpCode(500);
				userValidationDTO.setStatus(0);
				userValidationDTO.setError(errorDTO);
				return userValidationDTO;
				
			}
			
			if(afterDate > newDate){
				List<DoctorDTO> userDtoList = new ArrayList<>();
				doctorDTO.setPassword(utils.encrypyPassword(newPassword));
				userDtoList.add(doctorDTO);
				registerUserReop.save(doctorDTO);
				userValidationDTO.setHttpCode(200);
				userValidationDTO.setStatus(1);
				userValidationDTO.setUserDTos(userDtoList);
				return userValidationDTO;
				
			}else{
				errorDTO.setError(Constant.TIMEEXPIRE);
				errorDTO.setMessage(Constant.TIMEEXPIRE);
				userValidationDTO.setHttpCode(500);
				userValidationDTO.setStatus(0);
				userValidationDTO.setError(errorDTO);
				return userValidationDTO;
				
			}
		}else{
			errorDTO.setError(Constant.EMAILNOTFOUND);
			errorDTO.setMessage(Constant.EMAILNOTFOUND);
			userValidationDTO.setHttpCode(500);
			userValidationDTO.setStatus(0);
			userValidationDTO.setError(errorDTO);
			return userValidationDTO;
			
		}
		
	}

	@Override
	public boolean validateEmailAddress(String email) {
		DoctorEmailDTO emailDTO = emailRepo.isValidEmailByEmailAddress(email);
		if(emailDTO != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public EmailRequestDTO sendEmailWithToken(String email,String token) {
EmailRequestDTO emailDto = new EmailRequestDTO();
		
		DoctorDTO userDTO = registerUserReop.findByEmail(email);
		if(userDTO != null || (userDTO != null && !userDTO.getIsEmailVerify()) ){
			
			 String message = "<h1>Talk You Talk</h1>";
		        message += "<h2>We received a request to reset your password for your Talk You Talk account: </h2><br>";
		        message += email + "<h3>  We're here to help!</h3><br /> " ;
		        message += "<h3>Simply click on the button to set a new password:</h3> <br />";
		        message += "<h1>"+token + "</h1> <br />";
		        message +="<h3>If you didn't ask to change your password, don't worry! Your password is still safe and you can delete this email.</h3> </br /><br />";
		        message +="<h3> Cheers,</h3>";
				
				Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
				
				Mail mail = new Mail(new Email(sengridEmail), Constant.FORGTEMAILTOKENHEADER, new Email(email),new Content("text/html", message));
				mail.setReplyTo(new Email(sengridEmail));
				Request request = new Request();

				com.sendgrid.Response response = null;

				try {

					request.setMethod(Method.POST);

					request.setEndpoint("mail/send");

					request.setBody(mail.build());

					response=this.sendGrid.api(request);
				if(response.getStatusCode() == 200 || response.getStatusCode() == 202){
					Utils utils = new Utils();
//					userDTO.setUsrResetPasswrd(utils.encrypyPassword(token));
//					registerUserReop.save(userDTO);
					emailDto.setStatus("Email send");
					emailDto.setStatusCode(response.getStatusCode());
					return emailDto;
					
					}else{
						
						emailDto.setStatusCode(response.getStatusCode());
						emailDto.setStatus(response.getBody());
						return emailDto;
					}
				

			} catch (IOException ex) {

				System.out.println(ex.getMessage());

			}
			
		}
		
		return emailDto;
	}

	@Override
	public UserValidationDTO resetPassword(DoctorDTO dto) {
		DoctorDTO userDTO = registerUserReop.findByEmail(dto.getEmail());
		UserValidationDTO userValidationDTO = new UserValidationDTO();
		List<ValidationFactorsDTO> userDtoList = new ArrayList<ValidationFactorsDTO>();
		List<DoctorDTO> userDTOs = new ArrayList<>();
		Utils utils = new Utils();
		
//		if(!BCrypt.checkpw(dto.getPassword(),userDTO.get)){
//			ValidationFactorsDTO factorsDTO = new ValidationFactorsDTO();
//			factorsDTO.setFieldName(Constant.PASSWORD);
//			factorsDTO.setValidationError(Constant.LOGINFAIL);
//			userDtoList.add(factorsDTO);
////			userValidationDTO.setValidationFactor(validateUserDtoList);
//			userValidationDTO.setStatus(0);
//			userValidationDTO.setHttpCode(500);
//			userValidationDTO.setValidationFactor(userDtoList);
//			return userValidationDTO;
//		}else{
//			userDTO.setUsrPasswrd(utils.encrypyPassword(dto.getUsrPasswrd()));
//			userDTOs.add(userDTO);
//			registerUserReop.save(userDTO);
//			userValidationDTO.setStatus(1);
//			userValidationDTO.setHttpCode(200);
//			userValidationDTO.setUserDTos(userDTOs);
//			return userValidationDTO;
//		}
		return null;
	}
	
	
	
	


}
