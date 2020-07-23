package com.man.pro.customexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleException  {
	
	@ExceptionHandler
	@ResponseBody
	public String handleUserServiceException(UserServiceException exception) {
		
		System.out.println("Inside handleUserServiceException" +exception.getMessage());
		return exception.getMessage();
	}

}
