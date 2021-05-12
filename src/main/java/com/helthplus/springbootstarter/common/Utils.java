package com.helthplus.springbootstarter.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import org.mindrot.jbcrypt.BCrypt;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
public String getCloudinaryUrlByImage(String imagePath){
		
		try {
			String save_dir = "image";
			String app_path = "C:\\Users\\thush\\Desktop\\Ashan";
			System.out.println(app_path);
			String save_path=app_path+File.separator+save_dir;
			File f= new File(save_path);
			if(!f.exists()){
				f.mkdir();
			}
			
			File f1 = new File(save_path+"/image.jpg");
			
			FileOutputStream fos = new FileOutputStream(f1);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			 File file = new File(imagePath);
			  byte[] bytes = FileUtils.readFileToByteArray(file);		
			  System.out.println("Byte "+bytes);
			  
			 

			  Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			  "cloud_name", Constant.CLOUDINARY_CLOUD_NAME,
			  "api_key", Constant.CLOUDINARY_API_KEY,
			  "api_secret", Constant.CLOUDINARY_API_SECRET));
			  System.out.println("Byte1 "+bytes);
			  
			 Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			 Constant.LOGGER.info("Cloudinary Uplad result json "+uploadResult);	
			 System.out.println("uploadResult : "+uploadResult.get("url").toString());
			 String imageUrl = uploadResult.get("url").toString();
			 Constant.LOGGER.info("Cloudinary Uplad result image URL "+imageUrl);	
			 return imageUrl;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

public int generateToken(){
	Random rand = new Random(); 
	int token = rand.nextInt(Constant.EMAILRESETTOKEN); 
	return token;
	
}

public String getCloudinaryUrlByMultipartImage(MultipartFile multipartFile){
	try {
		  Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		  "cloud_name", Constant.CLOUDINARY_CLOUD_NAME,
		  "api_key", Constant.CLOUDINARY_API_KEY,
		  "api_secret", Constant.CLOUDINARY_API_SECRET));
		  
		  Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		  
//		 Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		 Constant.LOGGER.info("Cloudinary Uplad result json "+uploadResult);	
		 System.out.println("uploadResult : "+uploadResult.get("url").toString());
		 String imageUrl = uploadResult.get("url").toString();
		 Constant.LOGGER.info("Cloudinary Uplad result image URL "+imageUrl);	
		 return imageUrl;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}

	public String generateRandomNumber(){
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    java.util.Random random = new java.util.Random();
	
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	
	    return generatedString;
	}
	
	public String encrypyPassword(String password){
		String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(Constant.BYCRYPTSALT));
		return hashPassword;
	}
	


	 

}
