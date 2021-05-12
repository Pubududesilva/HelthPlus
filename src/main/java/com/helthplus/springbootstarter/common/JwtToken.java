package com.helthplus.springbootstarter.common;

import java.util.Date;

import com.helthplus.springbootstarter.domain.DoctorClinicDTO;
import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.PatientDTO;
import com.helthplus.springbootstarter.domain.UserDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {
	
	public String generateJWTToken(DoctorDTO dto){
		Long timeStamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constant.API_SECRET_KEY)
				.setIssuedAt(new Date(timeStamp))
				.setExpiration(new Date(timeStamp + Constant.TAKEN_VALIDITY))
				.claim("email", dto.getEmail())
				.claim("fullName", dto.getFirstName())
				.claim("userId", dto.getId())
				.compact();
		return token;
	}
	
	public String generateJWTTokenToUser(UserDTO dto){
		Long timeStamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constant.API_SECRET_KEY)
				.setIssuedAt(new Date(timeStamp))
				.setExpiration(new Date(timeStamp + Constant.TAKEN_VALIDITY))
				.claim("userName", dto.getUserName())
				.claim("FirstName", dto.getFirstName())
				.claim("rollId", dto.getRoleId())
				.claim("userId", dto.getId())
				.compact();
		return token;
	}
	
	public String generateJWTTokenToUser(DoctorClinicDTO dto){
		Long timeStamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constant.API_SECRET_KEY)
				.setIssuedAt(new Date(timeStamp))
				.setExpiration(new Date(timeStamp + Constant.TAKEN_VALIDITY))
				.claim("userName", dto.getEmail())
				.claim("docId", dto.getDoctorId())
				.claim("userId", dto.getId())
				.compact();
		return token;
	}
	

}
