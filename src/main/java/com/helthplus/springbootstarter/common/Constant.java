package com.helthplus.springbootstarter.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constant {
	
public static final String API_SECRET_KEY = "uteetalkyoutalkkey";
	
	public static final int BYCRYPTSALT = 10;
	
	public static final Long TAKEN_VALIDITY = (long) (24*60*60*1000*5); //5 Days valid
	
	public static final String CLOUDINARY_CLOUD_NAME = "dcgyhkvqy";
	
	public static final String CLOUDINARY_API_KEY = "623836192846579";
	
	public static final int EMAILRESETTOKEN = 10000;
	
	public static final String CLOUDINARY_API_SECRET = "SXJaUMulqAyqsZ7jrs0EyC8tj4A";
	
	public static final Long RESETPASSWORDVALIDTIME = (long) (60*1000*5); //5 minites valid
	
	public static final Logger LOGGER = LogManager.getLogger(Utils.class);
	
	public static final String FIRSTNAME = "First Name";
	
	public static final String USERNAME = "User Name";
	
	public static final String LASTNAME = "Last Name";
	
	public static final String INVALIDTOKEN = "Invalid Token";
	
	public static final String EMAIL = "Email";
	
	public static final String PASSWORD = "Password";
	
	public static final String EMPTYFIELD = "One or more required fields are missing";
	
	public static final String INVALIDFORMAT = "Invalid Format";
	
	public static final String EMAILNOTFOUND = "Email not found";
	
	public static final String NODATAFOUND = "No Data Found";
	
	public static final String TIMEEXPIRE = "Time Expire";
	
	public static final String LOGINFAIL = "Password incorrect. Login Fail";
	
	public static final String EMAILDUPLICATE = "Duplicate EMAIL Address";
	
	public static final String USERNAMEDUPLICATE = "Duplicate User Name";
	
	public static final String DUPLICATE_DATA = "Duplicate Data";
	
	public static final String INVALIDDATA = "Invalid Data";
	
	public static final String INVALIDBRANDNAME = "Invalid Brand Name";
	
	public static final String BRANDNAME_IS_AVAILABLE = "Brand name is already existed";
	
	public static final String SUPPLIER_IS_AVAILABLE = "Supplier name is already existed";
	
	public static final String DRUG_TYPE_IS_AVAILABLE = "Drug type name is already existed";
	
	public static final String EMAILALREADYSEND = "Email Already Send";
	
	public static final String INVALIDUSERNAME = "Invalid User Name";
	
	public static final String INVALIDSLMCNUMBER = "Invalid SLMC";
	
	public static final String EMAILNOTVERIFY = "Email Not Verify";
	
	public static final String USERALREADYASSIGN = "User Alrady Assigned";
	
	public static final String EMAILSUCESS = "Send Email Sucessfully";
	
	public static final String FORGTEMAILTOKENHEADER = "Reset your Talk You Talk password";
	
	public static final String SAVEFAILL = "Save Faill";
	
	
	

}
