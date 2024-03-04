package org.dnyanyog.common;

public enum ResponseCodes {
//	public final static String ADD_CUSTOMER_SUCCESS_CODE = "Success";
//	public final static String ADD_CUTOMER_SUCCESS_MESSAGE = "Customer added successfully";
//	
//	public final static String ADD_CUSTOMER_DUPLICATE_EMAIL_CODE = "FAIL";
//	public final static String ADD_CUSTOMER_DUPLICATE_EMAIL_MESSAGE = "This email is already used";
//	
//	public final static String ADD_CUSTOMER_DUPLICATE_PHONE_NUMBER_CODE = "FAIL";
//	public final static String ADD_CUSTOMER_DUPLICATE_PHONE_NUMBER_MESSAGE = "This phone number is already used";
//	
//	public final static String UPDATE_CUSTOMER_NOT_FOUND_EMAIL_CODE = "FAIL";
//	public final static String UPDATE_CUSTOMER_NOT_FOUND_EMAIL_MESSAGE = "Customer not found with this email";
//
//	public final static String UPDATE_CUSTOMER_NOT_FOUND_PHONE_NUMBER_CODE = "FAIL";
//	public final static String UPDATE_CUSTOMER_NOT_FOUND_PHONE_NUMBER_MESSAGE = "Customer not found with this phone number";
//
//	public final static String CUSTOMER_NOT_FOUND_CUSTOMER_ID_CODE = "FAIL";
//	public final static String CUSTOMER_NOT_FOUND_CUSTOMER_ID_MESSAGE = "Customer not found with this customer id";
//	
//	public final static String UPDATE_CUSTOMER_SUCCESS_CODE = "Success";
//	public final static String UPDATE_CUTOMER_SUCCESS_MESSAGE = "Customer data updated successfully";
//	
//	public final static String DELETE_CUSTOMER_SUCCESS_CODE = "Success";
//	public final static String DELETE_CUTOMER_SUCCESS_MESSAGE = "Customer deleted successfully";
	
	ADD_CUSTOMER_SUCCESS("Success", "Customer added successfully"),
	ADD_CUSTOMER_DUPLICATE_EMAIL("FAIL","This email is already used"),
	ADD_CUSTOMER_DUPLICATE_PHONE_NUMBER("FAIL","This phone number is already used"),
	UPDATE_CUSTOMER_NOT_FOUND_EMAIL("FAIL","Customer not found with this email"),
	UPDATE_CUSTOMER_NOT_FOUND_PHONE_NUMBER("FAIL","Customer not found with this phone number"),
	CUSTOMER_NOT_FOUND_CUSTOMER_ID("FAIL","Customer not found with this customer id"),
	UPDATE_CUSTOMER_SUCCESS("Success","Customer data updated successfully"),
	DELETE_CUSTOMER_SUCCESS("Success","Customer deleted successfully");
	
	private final String code;
	private final String message;
	
	ResponseCodes(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
