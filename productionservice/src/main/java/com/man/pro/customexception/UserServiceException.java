package com.man.pro.customexception;

public class UserServiceException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	
	private String message;

	

	public UserServiceException(String message) {
		
		System.out.println(message);
		
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
