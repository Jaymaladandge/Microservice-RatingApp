package com.rating.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource not found..");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
