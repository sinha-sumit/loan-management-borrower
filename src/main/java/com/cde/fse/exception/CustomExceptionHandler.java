package com.cde.fse.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*
	 * @ExceptionHandler(value = { IllegalArgumentException.class,
	 * IllegalStateException.class }) protected ResponseEntity<Object>
	 * handleConflict( RuntimeException ex, WebRequest request) { String
	 * bodyOfResponse = "This should be application specific"; return
	 * handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	 * HttpStatus.CONFLICT, request); }
	 */
	
	 @ExceptionHandler(LoginCustomException.class)
	    public final ResponseEntity<Object> handleAllExceptions(LoginCustomException ex) {
		 ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getTimestamp(),  ex.getDetails(), ex.getMessage());
			
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	    }
	 
	
		
	/*
	 * @Override protected ResponseEntity<Object> handleMethodArgumentNotValid(
	 * MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
	 * WebRequest request) {
	 * 
	 * ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
	 * "Validation Failed", ex.getBindingResult().toString());
	 * 
	 * return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	 * 
	 * //return handleExceptionInternal(ex, null, headers, status, request); }
	 */
	    
	 
	  
}
