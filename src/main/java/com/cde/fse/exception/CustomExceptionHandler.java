package com.cde.fse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(LoginCustomException.class)
	    public final ResponseEntity<Object> handleAllExceptions(LoginCustomException ex) {
		 ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getTimestamp(),  ex.getDetails(), ex.getMessage());
			
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	    }
	 
}
