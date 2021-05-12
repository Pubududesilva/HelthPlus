package com.helthplus.springbootstarter.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	HttpServletRequest httpRequest;

	
	@PostMapping("/setupprofile")
	public ResponseEntity<Map<String, String>>  fileUpload(@RequestParam("file") MultipartFile file,@RequestParam String userName) {
//		UserDTO dto = new UserDTO();
//		dto.setEmail(HttpRequest.getAttribute("email").toString());
//		dto.setUserName(userName);
//		UserDTO userDto = registerUserServices.updateUser(file,dto);
//		Utils utils = new Utils();
		Map<String,String> map = new HashMap<>();
		map.put("message", "File Uploaded sucessfully");
		  return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}


}
