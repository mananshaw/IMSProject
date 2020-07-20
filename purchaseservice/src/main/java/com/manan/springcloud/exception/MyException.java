package com.manan.springcloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyException {
	
	@ExceptionHandler(UserServiceException.class)
	public ResponseEntity<Object> myMessage(UserServiceException u) {
		return new ResponseEntity<>(u.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
