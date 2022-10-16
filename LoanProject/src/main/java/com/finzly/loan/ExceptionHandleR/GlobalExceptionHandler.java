package com.finzly.loan.ExceptionHandleR;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<MyError> idNotFoundException(Exception ex){
		MyError error = new MyError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<MyError>(error,HttpStatus.BAD_REQUEST);
	}
}
