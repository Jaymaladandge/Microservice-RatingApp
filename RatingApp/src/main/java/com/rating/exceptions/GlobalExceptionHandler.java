package com.rating.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,String>> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		Map<String,String> response =new HashMap<String, String>();
		response.put("message", ex.getMessage());
		response.put("success", "true");
		response.put("status", "Not Found");
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
	}
	
}
