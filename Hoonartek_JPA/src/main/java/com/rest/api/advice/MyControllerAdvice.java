package com.rest.api.advice;

import java.net.http.HttpHeaders;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.rest.api.exception.EmptyInputException;






@ControllerAdvice
public class MyControllerAdvice {
 
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input field is empty, please look!", HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("Employee id is not in Db, Please cheack", HttpStatus.NOT_FOUND);
	}
//      @Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
//    	  return new ResponseEntity<Object>("Please change your request",HttpStatus.NOT_FOUND);
//      }
}