package com.helthplus.springbootstarter.domain;

public class ValidationFactorsDTO {
	private String fieldName;
	
	private String validationError;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValidationError() {
		return validationError;
	}

	public void setValidationError(String validationError) {
		this.validationError = validationError;
	}
	

}
